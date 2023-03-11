package io.codeberg.jkpython.compiler.evaluator.builtins.types

import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNotImplemented
import io.codeberg.jkpython.compiler.evaluator.core.PyCallable
import io.codeberg.jkpython.compiler.evaluator.core.PyObject
import kotlin.math.floor
import kotlin.math.max

/**
 * [Reference](https://docs.python.org/3/library/stdtypes.html#textseq)
 */
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

    /* ========== Type Casting ========== */

    override fun __str__(): PyObject = this
    override fun __repr__(): PyString = PyString("<string: $value>")

    /* ========== Arithmetic Operators ========== */

    override fun __add__(other: PyObject): PyObject {
        if (other !is PyString) return PyNotImplemented
        return PyString(this.value + other.value)
    }

    // FIXME: There should be the reversed version of __mul__

    override fun __mul__(other: PyObject): PyObject {
        // FIXME: This should actually only accept PyInt
        if (other !is PyFloat) return PyNotImplemented
        if (floor(other.value) != other.value) error("TypeError: can't multiply sequence by non-int of type 'float'")
        return PyString(this.value.repeat(max(other.value.toInt(), 0)))
    }

    /* ========== Rich Comparison Operators ========== */

    override fun __eq__(other: PyObject): PyObject {
        if (other !is PyString) return PyNotImplemented
        return PyBool.of(value == other.value)
    }

    override fun __ne__(other: PyObject): PyObject {
        if (other !is PyString) return PyNotImplemented
        return PyBool.of(value != other.value)
    }

    /* ========== Container-Like Operations ========== */

    // FIXME: Should use PyInt
    override fun __len__(): PyObject = PyFloat.of(value.length.toDouble())
}