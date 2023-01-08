package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal

// FIXME: ContinueStatement will skip any StatementsBlock without raising an error

/**
 * Signals to a loop statement to skip the current iteration.
 */
class ContinueStatement : Statement(listOf()) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//    }

    override fun execute(context: Context): ExecutionSignal {
        return ExecutionSignal.ContinueIteration
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf()
}