package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject

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