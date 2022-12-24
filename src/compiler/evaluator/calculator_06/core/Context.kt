package evaluator.calculator_06.core

/**
 * The execution context.
 * Stores the variables list and their contents.
 */
abstract class Context(
    private val parent: Context?
) {
    constructor() : this(null)

    private val variables = HashMap<String, PyObject>()

    fun lookupVariable(name: String): PyObject = (variables[name] ?: parent?.lookupVariable(name))!!

    fun setVariable(name: String, value: PyObject) {
        variables[name] = value
    }
    fun createSubContext(): Context {
        return SubContext(this)
    }

    private class SubContext(parent: Context?) : Context(parent)
}