package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.expressions.Expression

class InfixExpression(
        private val firstOperand: Expression,
        private val operator: String,
        private val secondOperand: Expression,
) : Expression() {
    override fun evaluate(context: Context): PyObject {
        val first = firstOperand.evaluate(context)
        val second = secondOperand.evaluate(context)

        return when (operator) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            "/" -> first / second
            "==" -> first.equals(second)
            "!=" ->first.notEquals(second)
            ">" -> first.greater(second)
            "<"->first.less(second)
            ">="->first.greaterEquals(second)
            "<="->first.lessEquals(second)
            "&&"->first.and(second)
            "||"->first.or(second)
            else -> error("Unsupported infix operator: $operator")
        }
    }
}