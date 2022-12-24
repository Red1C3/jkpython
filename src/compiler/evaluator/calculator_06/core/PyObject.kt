package evaluator.calculator_06.core

import evaluator.calculator_06.builtins.constants.PyNotImplemented

interface PyObject {
    /* ========== Arithmetic Operators ========== */

    fun add(other: PyObject): PyObject {
        return PyNotImplemented
    }

    fun sub(other: PyObject): PyObject {
        return PyNotImplemented
    }

    fun mul(other: PyObject): PyObject {
        return PyNotImplemented
    }

    fun truediv(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /* ========== Kotlin Operators Overrides ========== */

    operator fun plus(other: PyObject): PyObject {
        val result = this.add(other)
        // TODO: Throw proper python exceptions
        if (result == PyNotImplemented) error("operation not implemented")
        return result
    }

    operator fun minus(other: PyObject): PyObject {
        val result = this.sub(other)
        // TODO: Throw proper python exceptions
        if (result == PyNotImplemented) error("operation not implemented")
        return result
    }

    operator fun times(other: PyObject): PyObject {
        val result = this.mul(other)
        // TODO: Throw proper python exceptions
        if (result == PyNotImplemented) error("operation not implemented")
        return result
    }

    operator fun div(other: PyObject): PyObject {
        val result = this.div(other)
        // TODO: Throw proper python exceptions
        if (result == PyNotImplemented) error("operation not implemented")
        return result
    }
}