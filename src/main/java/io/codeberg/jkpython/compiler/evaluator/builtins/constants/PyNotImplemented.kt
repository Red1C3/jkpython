package io.codeberg.jkpython.compiler.evaluator.builtins.constants

import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyString
import io.codeberg.jkpython.compiler.evaluator.core.PyObject

object PyNotImplemented : PyObject {
    override fun __repr__(): PyString = PyString("NotImplemented")
}