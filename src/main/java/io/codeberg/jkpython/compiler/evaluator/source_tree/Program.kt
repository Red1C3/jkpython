package io.codeberg.jkpython.compiler.evaluator.source_tree

import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.StatementsBlock
import io.codeberg.jkpython.compiler.evaluator.core.Context
import io.codeberg.jkpython.compiler.evaluator.core.Scope
import io.codeberg.jkpython.compiler.evaluator.core.SubScoped

/**
 * A sequence of expressions.
 *
 * It evaluates the expressions in the order provided and returns the result of the last expression.
 */
class Program(
        private val statements: StatementsBlock,
): SourceNode(listOf(statements)), SubScoped {

    override val scope = Scope(this)
    // FIXME: eagerly analyze the SymbolsTables of the program.

    /**
     * Optional, done automatically.
     * For loading the symbols tables eagerly.
     */
    fun loadSymbolsTable(environmentContext: Context) {
        environmentContext.createSubContext(scope)
    }

    fun run(environmentContext: Context) {
        val programContext = environmentContext.createSubContext(scope)
        statements.execute(programContext)
    }

    override fun getPrintableFields(): HashMap<String, Any?> {
        return hashMapOf(
            "statements" to statements,
            "symbols" to scope,
        )
    }

}