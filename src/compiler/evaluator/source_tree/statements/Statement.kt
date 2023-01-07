package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.SourceNode

abstract class Statement(children: List<SourceNode>) : SourceNode(children) {
    abstract fun execute(context: Context): ExecutionSignal
}