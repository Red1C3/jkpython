package compiler.evaluator.builtins.constants

import compiler.evaluator.builtins.types.PyString
import compiler.evaluator.core.PyObject

object PyNotImplemented : PyObject {
    override fun __repr__(): PyString = PyString("NotImplemented")
}