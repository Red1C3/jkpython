package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
//Will skip any block even outside a for loop (yes that's a bug)
class ContinueStatement:Statement() {
    override fun execute(context: Context): ExecutionSignal {
        return ExecutionSignal.ContinueOperation
    }
}