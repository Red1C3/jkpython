package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyBool
import compiler.evaluator.core.Context
import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyString
import compiler.evaluator.core.PyObject

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