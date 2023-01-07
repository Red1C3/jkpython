package compiler.evaluator.core

import compiler.evaluator.builtins.constants.PyNotImplemented

@Suppress("CovariantEquals")
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

    /* ========== Comparison Operators ========== */

    // == operator
    fun equals(other: PyObject): PyObject {
        return PyNotImplemented
    }

    // != operator
    fun notEquals(other: PyObject): PyObject {
        return PyNotImplemented
    }

    // not operator
    fun not(): PyObject {
        return PyNotImplemented
    }

    // > operator
    fun greater(other: PyObject): PyObject {
        return PyNotImplemented
    }

    // < operator
    fun less(other: PyObject) : PyObject {
        return PyNotImplemented
    }

    // >= operator
    fun greaterEquals(other: PyObject): PyObject {
        return PyNotImplemented
    }

    // <= operator
    fun lessEquals(other: PyObject): PyObject {
        return PyNotImplemented
    }
    // and operator
    fun and(other: PyObject): PyObject {
        return PyNotImplemented
    }

    // or operator
    fun or(other: PyObject): PyObject {
        return PyNotImplemented
    }
}