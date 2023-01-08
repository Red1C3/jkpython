package compiler.evaluator.core

import compiler.evaluator.builtins.constants.PyNotImplemented

/**
 * Reference: https://docs.python.org/3/reference/datamodel.html
 */
interface PyObject {
    /* ========== Arithmetic Operators ========== */

    /**
     * ('+' operator)
     * Reference: https://docs.python.org/3/reference/datamodel.html#object.__add__
     */
    @Suppress("FunctionName")
    fun __add__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /**
     * ('-' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__sub__)
     */
    @Suppress("FunctionName")
    fun __sub__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /**
     * ('*' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__mul__)
     */
    @Suppress("FunctionName")
    fun __mul__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /**
     * ('/' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__truediv__)
     */
    @Suppress("FunctionName")
    fun __truediv__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /* ========== Rich Comparison Operators ========== */

    /**
     * Less Than ('<' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__lt__)
     */
    @Suppress("FunctionName")
    fun __lt__(other: PyObject) : PyObject {
        return PyNotImplemented
    }

    /**
     * Less or Equal ('<=' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__le__)
     */
    @Suppress("FunctionName")
    fun __le__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /**
     * Equal ('==' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__eq__)
     */
    @Suppress("FunctionName")
    fun __eq__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /**
     * Not Equal ('!=' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__ne__)
     */
    @Suppress("FunctionName")
    fun __ne__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /**
     * Greater Than ('>' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__gt__)
     */
    @Suppress("FunctionName")
    fun __gt__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /**
     * Greater or Equal ('>=' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__ge__)
     */
    @Suppress("FunctionName")
    fun __ge__(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /* ========== Nonstandard Operators ========== */

    // FIXME: Those are non-standard operators, should be fixed.

    /**
     * ('not' operator).
     */
    fun not(): PyObject {
        return PyNotImplemented
    }

    /**
     * ('and' operator).
     */
    fun and(other: PyObject): PyObject {
        return PyNotImplemented
    }

    /**
     * ('or' operator).
     */
    fun or(other: PyObject): PyObject {
        return PyNotImplemented
    }
}