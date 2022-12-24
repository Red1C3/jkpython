package evaluator.calculator_06.builtins.functions

import evaluator.calculator_06.builtins.constants.PyNone
import evaluator.calculator_06.core.Context
import evaluator.calculator_06.core.PyCallable
import evaluator.calculator_06.core.PyObject

object PyPrint : PyCallable {
    // TODO: Add key based arguments
    // TODO: Do string casting the python way
    override fun call(context: Context, arguments: List<PyObject>): PyObject {
        println(arguments.joinToString(" ") { it.toString() })
        return PyNone
    }
}