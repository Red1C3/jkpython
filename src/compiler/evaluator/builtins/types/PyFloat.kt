package compiler.evaluator.builtins.types

import compiler.evaluator.builtins.constants.PyNone
import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.core.PyObject
import kotlin.math.pow

private fun toFloat(): Float? {
    return null
}

class PyFloat private constructor(
    val value: Double
) : PyObject {

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

    override fun toString(): String {
        return this.value.toString()
    }

    companion object {
        fun of(value: Double): PyFloat {
            // TODO: Cache the PyFloat instances
            return PyFloat(value)
        }
    }
}