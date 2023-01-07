package compiler.evaluator.builtins.types

import compiler.evaluator.core.PyObject

// TODO (rami): review lists code.

//Host language list container
class PyList(
    private var value: MutableList<PyObject>
) : PyObject {
    fun size(): Int {
        return value.size
    }

    fun addElement(elem: PyObject) {
        value.add(elem)
    }

    operator fun get(index: Int): PyObject {
        return value[index]
    }

    operator fun set(index: Int, newVal: PyObject) {
        value[index] = newVal
    }

    override fun toString(): String {
        return value.toString()
    }
}