package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.Statement

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