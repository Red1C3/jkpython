package compiler.evaluator.builtins.functions

import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject
import kotlin.math.floor

/**
 * [Reference](https://docs.python.org/3/library/functions.html#len)
 */
object PyLen : PyCallable {
    override fun call(arguments: List<PyObject>): PyObject {
        val obj = arguments.getOrNull(0)
        if (obj === null || arguments.size != 1) error("len() takes exactly one argument (${arguments.size} given)")
        val len = obj.__len__()
        // FIXME: Should use PyInt instead
        if (len !is PyFloat) error("TypeError: object cannot be interpreted as an integer")
        return PyFloat.of(floor(len.value))
    }
}