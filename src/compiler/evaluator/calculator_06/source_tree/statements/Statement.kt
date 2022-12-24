package evaluator.calculator_06.source_tree.statements

import evaluator.calculator_06.core.Context
import evaluator.calculator_06.core.ExecutionSignal
import evaluator.calculator_06.source_tree.SourceNode

abstract class Statement(children: List<SourceNode>) : SourceNode(children) {
    abstract fun execute(context: Context): ExecutionSignal
}