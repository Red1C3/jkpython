package compiler.evaluator.builtins.functions

import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject
import kotlin.math.roundToInt

// FIXME: this breaks Python standard, it should return a value of type 'range'.
// Reference: https://docs.python.org/3/library/stdtypes.html#ranges

/**
 * Range function
 *
 * - In case of a single parameter, it returns a list from 0 to that param exclusive.
 * - In case of two params, it returns a list from the first param to the second exclusive.
 */
object PyRange : PyCallable {
    override fun call(arguments: List<PyObject>): PyObject {

        if (arguments.size == 1 && arguments[0] is PyFloat) {
            val top = (arguments[0] as PyFloat).value
            val rangeList = arrayListOf<PyObject>()
            for (i in 0 until top.roundToInt())
                rangeList.add(PyFloat.of(i.toDouble()))
            return PyList(rangeList)
        }

        if (arguments.size == 2 && arguments[0] is PyFloat && arguments[1] is PyFloat) {
            val first = (arguments[0] as PyFloat).value
            val second = (arguments[1] as PyFloat).value
            val rangeList = arrayListOf<PyObject>()
            for (i in first.roundToInt() until second.roundToInt())
                rangeList.add(PyFloat.of(i.toDouble()))
            return PyList(rangeList)
        }

        return PyNotImplemented
    }
}