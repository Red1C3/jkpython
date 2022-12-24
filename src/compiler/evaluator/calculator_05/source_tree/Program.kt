package evaluator.calculator_05.source_tree

import evaluator.calculator_05.core.Context
import evaluator.calculator_05.source_tree.statements.StatementsBlock

/**
 * A sequence of expressions.
 *
 * It evaluates the expressions in the order provided and returns the result of the last expression.
 */
class Program(
    private val statements: StatementsBlock,
) {
    fun run(context: Context) {
        statements.execute(context)
    }
}