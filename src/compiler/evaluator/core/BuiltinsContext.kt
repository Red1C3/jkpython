package compiler.evaluator.core

import compiler.evaluator.builtins.functions.PyAppend
import compiler.evaluator.builtins.functions.PyPrint
import compiler.evaluator.builtins.functions.PyRange

val builtins = hashMapOf<String, PyObject>(
    "print" to PyPrint,
    "range" to PyRange,
    "append" to PyAppend,
)

val builtinsScope = Scope(null, builtins.keys.toList())

class BuiltinsContext : Context(builtinsScope) {
    init {
        builtins.forEach{ (name, value) -> setVariable(name, value)}
    }
}