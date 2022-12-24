package evaluator.calculator_06.source_tree.statements.expressions

import evaluator.calculator_06.core.Context
import evaluator.calculator_06.core.PyObject

class AssignmentExpression(
    private val target: Identifier,
    private val expression: Expression,
): Expression(listOf(target, expression)) {
    override fun evaluate(context: Context): PyObject {
        val result = expression.evaluate(context)
        context.setVariable(target.name, result)
        return result
    }
}