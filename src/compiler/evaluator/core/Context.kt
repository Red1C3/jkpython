package compiler.evaluator.core

import compiler.evaluator.visualization.SymbolTable

/**
 * The execution context.
 * Stores the variables list and their contents.
 */
abstract class Context(
    public val parent: Context?
) {
    constructor() : this(null)
    private val id:Int = i

    init {
        i++
    }

    public val variables = HashMap<String, PyObject>()


    fun lookupVariable(name: String): PyObject = (variables[name] ?: parent?.lookupVariable(name))!!

    fun setVariable(name: String, value: PyObject) {
        variables[name] = value
    }
    fun createSubContext(): Context {
        return SubContext(this)
    }

    private class SubContext(parent: Context?) : Context(parent){
        init {
            SymbolTable.instance().addContext(this)
        }
    }

    override fun toString(): String {
        return id.toString()
    }
    companion object{
        var i=0
    }
}