package io.codeberg.jkpython.compiler.evaluator.core

import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNone
import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNotImplemented
import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyString

/**
 * [Reference](https://docs.python.org/3/reference/datamodel.html)
 */
interface PyObject {

    /* ========== Type Casting ========== */

    /**
     * ('repr' function)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__repr__)
     *
     * `PyNotImplemented` is not allowed in this method.
     */
    @Suppress("FunctionName")
    fun __repr__(): PyString = PyString("<built-in '${this::class.qualifiedName}'>")

    /**
     * ('str' function)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__str__)
     */
    @Suppress("FunctionName")
    fun __str__(): PyObject = __repr__()

    /**
     * ('bool' function)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__bool__)
     */
    @Suppress("FunctionName")
    fun __bool__(): PyObject = PyNotImplemented

    /**
     * ('int' function)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__int__)
     */
    @Suppress("FunctionName")
    fun __int__(): PyObject = PyNotImplemented

    /**
     * ('float' function)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__float__)
     */
    @Suppress("FunctionName")
    fun __float__(): PyObject = PyNotImplemented

    // TODO: Spread the usage of the types casting methods.

    /* ========== Container-Like Operations ========== */

    /**
     * ('len' function)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__len__)
     */
    @Suppress("FunctionName")
    fun __len__(): PyObject = PyNotImplemented

    /* ========== Arithmetic Operators ========== */

    /**
     * ('+' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__add__)
     */
    @Suppress("FunctionName")
    fun __add__(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('-' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__sub__)
     */
    @Suppress("FunctionName")
    fun __sub__(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('*' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__mul__)
     */
    @Suppress("FunctionName")
    fun __mul__(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('@' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__matmul__)
     */
    @Suppress("FunctionName")
    fun __matmul__(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('/' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__truediv__)
     */
    @Suppress("FunctionName")
    fun __truediv__(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('//' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__floordiv__)
     */
    @Suppress("FunctionName")
    fun __floordiv__(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('%' operator)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__mod__)
     */
    @Suppress("FunctionName")
    fun __mod__(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('divmod' function)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__truediv__)
     */
    @Suppress("FunctionName")
    fun __divmod__(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('**' operator or 'pow' function)
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__pow__)
     */
    @Suppress("FunctionName")
    fun __pow__(exp: PyObject, mod: PyObject = PyNone): PyObject = PyNotImplemented

    // Bitwise Operators

    // TODO: __lshift__
    // TODO: __rshift__
    // TODO: __and__
    // TODO: __xor__
    // TODO: __or__

    /* ========== Rich Comparison Operators ========== */

    /**
     * Less Than ('<' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__lt__)
     */
    @Suppress("FunctionName")
    fun __lt__(other: PyObject) : PyObject = PyNotImplemented

    /**
     * Less or Equal ('<=' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__le__)
     */
    @Suppress("FunctionName")
    fun __le__(other: PyObject): PyObject = PyNotImplemented

    /**
     * Equal ('==' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__eq__)
     */
    @Suppress("FunctionName")
    fun __eq__(other: PyObject): PyObject = PyNotImplemented

    /**
     * Not Equal ('!=' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__ne__)
     */
    @Suppress("FunctionName")
    fun __ne__(other: PyObject): PyObject = PyNotImplemented

    /**
     * Greater Than ('>' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__gt__)
     */
    @Suppress("FunctionName")
    fun __gt__(other: PyObject): PyObject = PyNotImplemented

    /**
     * Greater or Equal ('>=' operator).
     * [Reference](https://docs.python.org/3/reference/datamodel.html#object.__ge__)
     */
    @Suppress("FunctionName")
    fun __ge__(other: PyObject): PyObject = PyNotImplemented

    /* ========== Nonstandard Operators ========== */

    // FIXME: Those are non-standard operators, should be fixed.

    /**
     * ('not' operator).
     */
    fun not(): PyObject = PyNotImplemented

    /**
     * ('and' operator).
     */
    fun and(other: PyObject): PyObject = PyNotImplemented

    /**
     * ('or' operator).
     */
    fun or(other: PyObject): PyObject = PyNotImplemented
}