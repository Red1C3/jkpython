package compiler.evaluator.builtins.functions

import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.expressions.Literal
import kotlin.math.roundToInt
//Range function
//In case of a single parameter, it returns a list from 0 to that param exclusive
//In case of two params, it returns a list from the first param to the second exclusive
object PyRange:PyCallable {
    override fun call(context: Context, arguments: List<PyObject>): PyObject {
        if (arguments.size==1 && arguments[0] is PyFloat){
            val top=(arguments[0] as PyFloat).value
            val rangeList= arrayListOf<PyObject>()
            for (i in 0 until top.roundToInt()){
                rangeList.add(PyFloat(i.toDouble()))
            }
            return PyList(rangeList)
        }
        if(arguments.size==2 && arguments[0] is PyFloat && arguments[1] is PyFloat){
            val first=(arguments[0] as PyFloat).value
            val second=(arguments[1] as PyFloat).value
            val rangeList= arrayListOf<PyObject>()
            for (i in first.roundToInt() until second.roundToInt()){
                rangeList.add(PyFloat(i.toDouble()))
            }
            return PyList(rangeList)
        }
        return PyNotImplemented
    }
}