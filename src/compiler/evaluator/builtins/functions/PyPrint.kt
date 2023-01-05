package compiler.evaluator.builtins.functions

import compiler.evaluator.builtins.constants.PyNone
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject

object PyPrint : PyCallable {
    // TODO: Add key based arguments
    // TODO: Do string casting the python way
    override fun call(context: Context, arguments: List<PyObject>): PyObject {
        println(arguments.joinToString(" ") { it.toString() })
        return PyNone
    }
}