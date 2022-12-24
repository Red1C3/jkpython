package evaluator.calculator_05.source_tree.statements.expressions

import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.PyObject

class AssignmentExpression(
    private val target: Identifier,
    private val expression: Expression,
): Expression() {
    override fun evaluate(context: Context): PyObject {
        val result = expression.evaluate(context)
        context.setVariable(target.name, result)
        return result
    }
}