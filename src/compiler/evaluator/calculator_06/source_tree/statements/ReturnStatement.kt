package evaluator.calculator_06.source_tree.statements

import evaluator.calculator_06.builtins.constants.PyNone
import evaluator.calculator_06.core.Context
import evaluator.calculator_06.core.ExecutionSignal
import evaluator.calculator_06.source_tree.statements.expressions.Expression
import evaluator.calculator_06.source_tree.statements.expressions.Literal

class ReturnStatement(
    val value: Expression = Literal(PyNone)
) : Statement(listOf(value)) {
    override fun execute(context: Context): ExecutionSignal {
        return ExecutionSignal.Return(value.evaluate(context))
    }
}