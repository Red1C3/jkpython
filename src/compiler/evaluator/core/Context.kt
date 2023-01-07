package compiler.evaluator.core

/**
 * The execution context.
 * Stores the variables list and their contents.
 */
abstract class Context(
        val scope: Scope,
        val parent: Context? = null,
) {
    private val scopesChain: List<Scope> = (parent?.scopesChain ?: listOf()) + listOf(scope)

    private val variables = HashMap<String, PyObject>()

    init {
        scope.analyze(scopesChain)
    }

    fun lookupVariable(name: String): PyObject {
        val symbolContext = scope.findSymbolContext(name, this)
        val value = symbolContext.variables[name]
        if (value === null) throw Error("cannot access local variable '$name' where it is not associated with a value")
        return value
    }

    fun setVariable(name: String, value: PyObject) {
        val symbolContext = scope.findSymbolContext(name, this)
        symbolContext.variables[name] = value
    }

    fun createSubContext(subScope: Scope): Context {
        return SubContext(subScope, this)
    }

    private class SubContext(scope: Scope, parent: Context) : Context(scope, parent)
}