package evaluator.calculator_05.source_tree.statements

import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.ExecutionSignal

abstract class Statement {
    abstract fun execute(context: Context): ExecutionSignal
}