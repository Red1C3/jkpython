package io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions

import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyBool
import io.codeberg.jkpython.compiler.evaluator.core.Context
import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyFloat
import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyString
import io.codeberg.jkpython.compiler.evaluator.core.PyObject

class Literal(
    value: Any
) : Expression(listOf()) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//    }

    private val pyValue: PyObject = when (value) {
        is Float -> PyFloat.of(value.toDouble())
        is Double -> PyFloat.of(value)
        is String -> PyString(value)
        is Boolean -> PyBool.of(value)
        is PyObject -> value
        else -> error("Unsupported literal value type: ${value.javaClass.canonicalName}")
    }

    override fun evaluate(context: Context) = pyValue

    override fun getPrintableFields(): HashMap<String, Any?> {
        val str = pyValue.__str__()
        if (str is PyString) return hashMapOf("value" to str.value)
        return hashMapOf("value" to "\"${str.__repr__().value}\"")
    }
}