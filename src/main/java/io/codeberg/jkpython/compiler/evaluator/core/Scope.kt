package io.codeberg.jkpython.compiler.evaluator.core

import io.codeberg.jkpython.compiler.evaluator.core.VisitorSignal.CONTINUE
import io.codeberg.jkpython.compiler.evaluator.core.VisitorSignal.SKIP_CHILDREN
import io.codeberg.jkpython.compiler.evaluator.source_tree.SourceNode
import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.ForStatement
import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.FunctionDeclaration
import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions.AssignmentExpression
import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions.Identifier

/**
 * The scope and all inner-scopes it has are analyzed as soon as the first
 * sub-context is created.
 */
class Scope(
        private val sourceNode: SourceNode?,
        injectedSymbols: List<String> = listOf(),
) {
    private val symbolsTable = hashMapOf<String, Int>()
    private val unresolvedSymbols = hashSetOf<String>()

    var analyzed = sourceNode === null
        private set

    init {
        injectedSymbols.forEach { symbolsTable[it] = 0 }
    }

    fun findSymbolContext(symbolName: String, context: Context): Context {
        if (!analyzed) throw Error("The scope has not been analyzed!")

        val depth = symbolsTable[symbolName]
        if (depth === null) throw Error("name '$symbolName' is not defined")

        var targetContext = context
        for (i in 1..depth) targetContext = targetContext.parent!!
        return targetContext
    }

    fun analyze(outerScopes: List<Scope> = mutableListOf()) {
        if (sourceNode === null || analyzed) return
        analyzed = true

        val innerScopes = mutableListOf<Scope>()

        sourceNode.explore { node ->
            // TODO: Support 'global' and 'nonlocal' statements.
            if (node === sourceNode) return@explore CONTINUE
            if (node is Identifier) unresolvedSymbols.add(node.name)

            if (node is FunctionDeclaration) symbolsTable.putIfAbsent(node.id.name, 0)
            if (node is AssignmentExpression) symbolsTable.putIfAbsent(node.target.name, 0)
            if (node is ForStatement) symbolsTable.putIfAbsent(node.iterator.name, 0)

            if (node is SubScoped && node.scope !== this) {
                innerScopes.add(node.scope)
                return@explore SKIP_CHILDREN
            }

            CONTINUE
        }

        // Remove all the resolved symbols
        unresolvedSymbols.removeAll(symbolsTable.keys)

        // Attempt to resolve the unresolved symbols from the outer scopes.
        id@ for (symbolName in unresolvedSymbols) {
            scope@ for ((depth, scope) in outerScopes.withIndex()) {
                if (!scope.analyzed) throw Error("The outer-scope $scope is not analyzed!")
                if (!scope.symbolsTable.containsKey(symbolName)) continue@scope

                symbolsTable[symbolName] = outerScopes.size - depth - 1
                continue@id
            }
        }

        // Remove all the resolved symbols again
        unresolvedSymbols.removeAll(symbolsTable.keys)
        // Any remaining unresolved symbols will simply rais "undefined variable" error on runtime.

        // Analyze the inner-scopes
        val scopesChain = outerScopes + listOf(this)
        innerScopes.forEach{ it.analyze(scopesChain) }
    }

    override fun toString(): String {
        if (!analyzed) return "NOT ANALYZED"
        return "{ ${this.symbolsTable.toList().joinToString(", ") { (key, value) -> "\"$key\": $value" }} }"
    }
}
