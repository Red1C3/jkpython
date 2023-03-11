package io.codeberg.jkpython.compiler.evaluator.builtins.types

import io.codeberg.jkpython.compiler.evaluator.core.PyObject

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

    override fun __repr__(): PyString = PyString("[${value.joinToString(", ") { 
        when (val value = it.__str__()) {
            is PyString -> value.value
            else -> value.__repr__().value
        }
    }}]")

    override fun __len__(): PyObject = PyFloat.of(value.size.toDouble())
}