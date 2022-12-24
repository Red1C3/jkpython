package evaluator.calculator_05.builtins.types

import evaluator.calculator_05.builtins.constants.PyNotImplemented
import evaluator.calculator_05.core.PyObject

class PyString(
    val value: String
) : PyObject {
    override fun add(other: PyObject): PyObject {
        // TODO: Attempt casting into a string.
        if (other !is PyString) return PyNotImplemented
        return PyString(this.value + other.value)
    }

    override fun toString(): String {
        return value
    }
}