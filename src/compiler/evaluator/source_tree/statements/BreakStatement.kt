package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.Statement
//Will break any block (even outside of for loops)
class BreakStatement :Statement() {
    override fun execute(context: Context): ExecutionSignal {
        return ExecutionSignal.BreakOperation
    }
}