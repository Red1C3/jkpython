package compiler.evaluator.builtins.functions

import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject

/**
 * [Reference](https://docs.python.org/3/library/functions.html#repr)
 */
object PyRepr : PyCallable {
    override fun call(arguments: List<PyObject>): PyObject {
        val obj = arguments.getOrNull(0)
        if (obj === null || arguments.size != 1) error("len() takes exactly one argument (${arguments.size} given)")
        return obj.__repr__()
    }
}