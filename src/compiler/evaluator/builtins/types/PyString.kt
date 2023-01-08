package compiler.evaluator.builtins.types

import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject

class PyString(
    val value: String
) : PyObject {

    /**
     * The `str` constructor/function.
     */
    companion object : PyCallable {
        override fun call(arguments: List<PyObject>): PyObject {
            // TODO: Support 'encoding' and 'errors' parameters.
            val obj = (arguments.getOrNull(0) ?: PyString("")).__str__()
            if (obj !is PyString) error("TypeError: __str__ returned non-string (${obj.__repr__().value})")
            return obj
        }
    }

    override fun __str__(): PyObject = this

    override fun __add__(other: PyObject): PyObject {
        // TODO: Attempt casting into a string.
        if (other !is PyString) return PyNotImplemented
        return PyString(this.value + other.value)
    }

    override fun __eq__(other: PyObject): PyObject {
        if (other !is PyString) return PyNotImplemented
        return PyBool.of(value == other.value)
    }

    override fun __ne__(other: PyObject): PyObject {
        if (other !is PyString) return PyNotImplemented
        return PyBool.of(value != other.value)
    }
}