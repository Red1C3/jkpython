package evaluator.calculator_05.source_tree.statements

import evaluator.calculator_05.builtins.constants.PyNone
import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.ExecutionSignal
import evaluator.calculator_05.source_tree.statements.expressions.Expression
import evaluator.calculator_05.source_tree.statements.expressions.Literal

class ReturnStatement(
    val value: Expression = Literal(PyNone)
) : Statement() {
    override fun execute(context: Context): ExecutionSignal {
        return ExecutionSignal.Return(value.evaluate(context))
    }
}