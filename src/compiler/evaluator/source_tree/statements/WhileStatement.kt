package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.types.PyBool
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.expressions.Expression

class WhileStatement(
        private val condition: Expression,
        private val block: StatementsBlock
        ):Statement() {
    override fun execute(context: Context): ExecutionSignal {
        while((condition.evaluate(context) as PyBool).value){
            val signal = block.execute(context)
            if(signal==ExecutionSignal.BreakOperation) break
        }
        return ExecutionSignal.NormalOperation
    }
}