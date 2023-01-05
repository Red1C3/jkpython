package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal

abstract class Statement {
    abstract fun execute(context: Context): ExecutionSignal
}