package evaluator.calculator_06.builtins.types

import evaluator.calculator_06.builtins.constants.PyNotImplemented
import evaluator.calculator_06.core.PyObject

class PyFloat private constructor(
    val value: Double
) : PyObject {

    override fun add(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value + other.value)
    }

    override fun sub(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value - other.value)
    }

    override fun mul(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value * other.value)
    }

    override fun truediv(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return of(this.value / other.value)
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