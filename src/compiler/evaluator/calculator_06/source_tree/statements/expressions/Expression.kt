package evaluator.calculator_06.source_tree.statements.expressions

import evaluator.calculator_06.core.Context
import evaluator.calculator_06.core.ExecutionSignal
import evaluator.calculator_06.core.PyObject
import evaluator.calculator_06.source_tree.SourceNode
import evaluator.calculator_06.source_tree.statements.Statement

abstract class Expression(children: List<SourceNode>) : Statement(children) {
    abstract fun evaluate(context: Context): PyObject

    /**
     * Expressions can be executed as normal statements, but their value would be discarded.
     */
    final override fun execute(context: Context): ExecutionSignal {
        evaluate(context)
        return ExecutionSignal.NormalOperation
    }
}