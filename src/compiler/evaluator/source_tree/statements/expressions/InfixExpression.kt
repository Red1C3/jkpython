package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.constants.PyNotImplemented
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject

class InfixExpression(
        private val firstOperand: Expression,
        private val operator: String,
        private val secondOperand: Expression,
) : Expression(listOf(firstOperand, secondOperand)) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this, firstOperand, LabeledEdge())
//        AST.instance().g.addEdge(this, secondOperand, LabeledEdge())
//    }

    override fun toString(): String {
        return operator
    }

    override fun evaluate(context: Context): PyObject {
        val first = firstOperand.evaluate(context)
        val second = secondOperand.evaluate(context)

        val result = when (operator) {
            "+" -> first.add(second)
            "-" -> first.sub(second)
            "*" -> first.mul(second)
            "/" -> first.truediv(second)
            "==" -> first.equals(second)
            "!=" -> first.notEquals(second)
            ">" -> first.greater(second)
            "<" -> first.less(second)
            ">=" -> first.greaterEquals(second)
            "<=" -> first.lessEquals(second)
            "&&" -> first.and(second)
            "||" -> first.or(second)
            else -> error("Invalid infix operator: $operator")
        }

        if (result == PyNotImplemented) error("operation not implemented")
        return result
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "first" to firstOperand,
        "operator" to operator,
        "second" to secondOperand,
    )
}