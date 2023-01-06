package compiler.evaluator.builtins.types

import compiler.evaluator.core.PyObject
//Host language list container
class PyList(
        private var value:MutableList<PyObject>
): PyObject {
    public fun size():Int{
        return value.size
    }
    operator fun get(index:Int):PyObject{
        return value[index]
    }
    operator fun set(index:Int,newVal:PyObject){
        value[index]=newVal
    }
    override fun toString(): String {
        return value.toString()
    }
}