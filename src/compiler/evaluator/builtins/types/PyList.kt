package compiler.evaluator.builtins.types

import compiler.evaluator.core.PyObject
//Host language list container
class PyList(
        private val value:List<PyObject>
): PyObject {
    public fun size():Int{
        return value.size
    }
    operator fun get(index:Int):PyObject{
        return value[index]
    }
    override fun toString(): String {
        return value.toString()
    }
}