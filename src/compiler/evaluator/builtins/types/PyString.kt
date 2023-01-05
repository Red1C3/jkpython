package compiler.evaluator.builtins.types

import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.core.PyObject

class PyString(
    val value: String
) : PyObject {
    override fun add(other: PyObject): PyObject {
        // TODO: Attempt casting into a string.
        if (other !is PyString) return PyNotImplemented
        return PyString(this.value + other.value)
    }

    override fun equals(other: PyObject): PyObject {
        if(other !is PyString) return PyNotImplemented
        return PyBool.of(value == other.value)
    }

    override fun notEquals(other: PyObject): PyObject {
        if (other !is PyString) return PyNotImplemented
        return PyBool.of(value!=other.value)
    }
    override fun toString(): String {
        return value
    }
}