package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyBool
import compiler.evaluator.core.Context
import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyString
import compiler.evaluator.core.PyObject
import compiler.evaluator.visualization.AST

class Literal constructor (
    val value: Any
): Expression() {
    init {
        AST.instance().g.addVertex(this)
    }
    private val pyValue: PyObject = when (value) {
        is Float -> PyFloat.of(value.toDouble())
        is Double -> PyFloat.of(value)
        is String -> PyString(value)
        is Boolean -> PyBool(value)
        is PyObject -> value
        else -> error("Unsupported literal value type: ${value.javaClass.canonicalName}")
    }

    override fun evaluate(context: Context)= pyValue
    public override fun  toString():String{
        return value.toString()
    }
}