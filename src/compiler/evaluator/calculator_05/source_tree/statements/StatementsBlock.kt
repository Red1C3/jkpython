package evaluator.calculator_05.source_tree.statements

import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.ExecutionSignal

class StatementsBlock(
    private vararg val statements: Statement
): Statement() {
    override fun execute(context: Context): ExecutionSignal {
        for (statement in statements) {
            val signal = statement.execute(context)
            if (signal !== ExecutionSignal.NormalOperation)
                return signal
        }

        return ExecutionSignal.NormalOperation
    }
}