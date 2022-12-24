package evaluator.calculator_05.source_tree.statements.expressions

import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.ExecutionSignal
import evaluator.calculator_05.core.PyObject
import evaluator.calculator_05.source_tree.statements.Statement

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