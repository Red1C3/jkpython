package io.codeberg.jkpython.compiler.evaluator.core

import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNone
import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNotImplemented
import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyBool
import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyString
import io.codeberg.jkpython.compiler.evaluator.builtins.functions.*

val builtins = hashMapOf(
    // Constants
    "None" to PyNone,
    "NotImplemented" to PyNotImplemented,
    "True" to PyBool.of(true),
    "False" to PyBool.of(false),
    // Functions
    "print" to PyPrint,
    "len" to PyLen,
    "repr" to PyRepr,
    "range" to PyRange,
    "append" to PyAppend,
    // Types (can be used as functions for constructing instances).
    "str" to PyString,
)

val builtinsScope = Scope(null, builtins.keys.toList())

class BuiltinsContext : Context(builtinsScope) {
    init {
        builtins.forEach{ (name, value) -> setVariable(name, value)}
    }
}