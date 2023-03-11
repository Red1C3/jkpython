package io.codeberg.jkpython.compiler.evaluator.builtins.types

import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNotImplemented
import io.codeberg.jkpython.compiler.evaluator.core.PyObject

class PyBool private constructor(
    val value: Boolean
) : PyObject {
    override fun __repr__(): PyString = PyString(if (value) "True" else "False")

    override fun __eq__(other: PyObject): PyObject {
        if (other !is PyBool) return PyNotImplemented
        return of(value == other.value)
    }

    override fun __ne__(other: PyObject): PyObject {
        if (other !is PyBool) return PyNotImplemented
        return of(value != other.value)
    }

    override fun and(other: PyObject): PyObject {
        if (other !is PyBool) return PyNotImplemented
        return of(value && other.value)
    }

    override fun or(other: PyObject): PyObject {
        if (other !is PyBool) return PyNotImplemented
        return of(value || other.value)
    }

    override fun not(): PyObject {
        return of(!value)
    }

    companion object {
        private val True = PyBool(true)
        private val False = PyBool(false)

        fun of(value: Boolean): PyBool {
            return if (value) True else False
        }
    }
}