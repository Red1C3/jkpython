package compiler.evaluator.builtins.functions

import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject

// TODO: This is a non-standard method, maybe it should be move to a package will all the non-standard stuff.

//Add a PyObject to a PyList
//In plain English, it adds a new element (no matter what type it is) to a list increasing its size by 1
object PyAppend : PyCallable {
    override fun call(arguments: List<PyObject>): PyObject {
        if (arguments.size == 2 && arguments[0] is PyList) {
            (arguments[0] as PyList).addElement(arguments[1]) // FIXME: when appending a list to itself it fails
            return arguments[0]
        }
        return PyNotImplemented
    }
}