package compiler.evaluator.builtins.types

import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.core.PyObject

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

    @Suppress("CovariantEquals")
    override fun equals(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value == other.value)
    }

    override fun notEquals(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value != other.value)
    }

    override fun less(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value < other.value)
    }

    override fun greater(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value > other.value)
    }

    override fun lessEquals(other: PyObject): PyObject {
        if (other !is PyFloat) return PyNotImplemented
        return PyBool.of(value <= other.value)
    }

    override fun greaterEquals(other: PyObject): PyObject {
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