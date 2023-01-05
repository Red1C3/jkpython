package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.Statement

abstract class Expression : Statement() {
    abstract fun evaluate(context: Context): PyObject

    /**
     * Expressions can be executed as normal statements, but their value would be discarded.
     */
    final override fun execute(context: Context): ExecutionSignal {
        evaluate(context)
        return ExecutionSignal.NormalOperation
    }
}