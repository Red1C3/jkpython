package evaluator.calculator_06.source_tree.statements.expressions

import evaluator.calculator_06.core.Context
import evaluator.calculator_06.core.PyObject

// TODO: Possibly find a better name for this as it works on strings.

class ArithmeticExpression(
    private val firstOperand: Expression,
    private val operator: Char,
    private val secondOperand: Expression,
) : Expression(listOf(firstOperand, secondOperand)) {
    override fun evaluate(context: Context): PyObject {
        val first = firstOperand.evaluate(context)
        val second = secondOperand.evaluate(context)

        return when (operator) {
            '+' -> first + second
            '-' -> first - second
            '*' -> first * second
            '/' -> first / second
            else -> error("Unsupported arithmetic operator: $operator")
        }
    }
}