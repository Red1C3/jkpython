package io.codeberg.jkpython.compiler.evaluator.builtins.types

import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNone
import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNotImplemented
import io.codeberg.jkpython.compiler.evaluator.core.PyObject
import kotlin.math.pow

class PyFloat private constructor(
    val value: Double
) : PyObject {

    override fun __repr__(): PyString = PyString("$value")

    /* ========== Arithmetic Operators ========== */

    override fun __add__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value + other.value)
    }

    override fun __sub__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value - other.value)
    }

    override fun __mul__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value * other.value)
    }

    override fun __truediv__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value / other.value)
    }

    override fun __mod__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value % other.value)
    }

    override fun __pow__(exp: PyObject, mod: PyObject): PyObject {
        if (exp !is PyFloat) return PyNotImplemented
        if (mod !== PyNone && mod !is PyFloat) return PyNotImplemented

        var result = this.value.pow(exp.value)
        if (mod is PyFloat) result %= mod.value

        return of(result)
    }

    /* ========== Rich Comparison Operators ========== */

    override fun __eq__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value == other.value)
    }

    override fun __ne__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value != other.value)
    }

    override fun __lt__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value < other.value)
    }

    override fun __gt__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value > other.value)
    }

    override fun __le__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value <= other.value)
    }

    override fun __ge__(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value >= other.value)
    }

    companion object {
        fun of(value: Double): PyFloat {
            // TODO: Cache the PyFloat instances
            return PyFloat(value)
        }
    }
}