package compiler.evaluator.source_tree

import compiler.evaluator.core.Context
import compiler.evaluator.source_tree.statements.StatementsBlock

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