package evaluator.calculator_06.source_tree

import evaluator.calculator_06.source_tree.statements.StatementsBlock
import evaluator.calculator_06.core.Context

/**
 * A sequence of expressions.
 *
 * It evaluates the expressions in the order provided and returns the result of the last expression.
 */
class Program(
    private val statements: StatementsBlock,
): SourceNode(listOf(statements)) {
    fun run(context: Context) {
        statements.execute(context)
    }
}