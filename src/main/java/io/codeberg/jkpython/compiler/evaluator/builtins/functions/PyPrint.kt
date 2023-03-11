package io.codeberg.jkpython.compiler.evaluator.builtins.functions

import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNone
import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyString
import io.codeberg.jkpython.compiler.evaluator.core.PyCallable
import io.codeberg.jkpython.compiler.evaluator.core.PyObject

object PyPrint : PyCallable {
    // TODO: Add key based arguments
    override fun call(arguments: List<PyObject>): PyObject {
        println(arguments.joinToString(" ") {
            when (val value = it.__str__()) {
                is PyString -> value.value
                else -> error("TypeError: __str__ returned non-string (${value.__repr__().value})")
            }
        })

        return PyNone
    }
}