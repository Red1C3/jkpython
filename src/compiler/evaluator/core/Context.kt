package compiler.evaluator.core

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
        //Look in outer scopes before defining a new var
        var parent:Context?=this.parent
        while(parent!=null){
            if(parent.variables.containsKey(name)){
                parent.variables[name]=value
                return
            }
            parent=parent.parent
        }
        variables[name] = value
    }
    fun createSubContext(): Context {
        return SubContext(this)
    }

    private class SubContext(parent: Context?) : Context(parent)
}