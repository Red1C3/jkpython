package evaluator.calculator_05.builtins.functions

import evaluator.calculator_05.builtins.constants.PyNone
import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.PyCallable
import evaluator.calculator_05.core.PyObject

object PyPrint : PyCallable {
    // TODO: Add key based arguments
    // TODO: Do string casting the python way
    override fun call(context: Context, arguments: List<PyObject>): PyObject {
        println(arguments.joinToString(" ") { it.toString() })
        return PyNone
    }
}