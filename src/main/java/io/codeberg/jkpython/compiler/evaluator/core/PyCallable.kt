package io.codeberg.jkpython.compiler.evaluator.core

import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyString

/**
 * This was not designed as a special method on `PyObject` because the builtin python function `callable`
 * should be able to tell if an object is callable or not, and that could be done using the Kotlin `is` operator.
 */
interface PyCallable : PyObject {
    fun call(arguments: List<PyObject> = listOf()): PyObject

    override fun __repr__(): PyString = PyString("<built-in function ${
        this::class.simpleName?.substring(2)?.lowercase()
    }>")
}