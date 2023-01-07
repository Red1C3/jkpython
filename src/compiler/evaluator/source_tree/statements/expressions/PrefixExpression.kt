package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject

/**
 * For operations with a single operator that precedes the expression, such as not
 */
class PrefixExpression(
        private val operator: String,
        private val operand: Expression,
) : Expression(listOf(operand)) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this, operand, LabeledEdge())
//    }

    override fun evaluate(context: Context): PyObject {
        val value = operand.evaluate(context)
        val result = when (operator) {
            "!" -> value.not()
            else -> error("Invalid prefix operator: $operator")
        }

        if (result == PyNotImplemented) error("operation not implemented")
        return result
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "operator" to operator,
        "operand" to operand,
    )
}