package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.types.PyBool
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.expressions.Expression

class WhileStatement(
        private val condition: Expression,
        private val body: StatementsBlock,
) : Statement(listOf(condition, body)) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this, condition, LabeledEdge("cond"))
//        AST.instance().g.addEdge(this, body, LabeledEdge())
//    }

    override fun execute(context: Context): ExecutionSignal {
        // Evaluate the condition expression until it returns false
        while (isConditionSatisfied(condition.evaluate(context))) { // FIXME: handle floats and string conditions
            // Execute the statements block each loop unless it faces a break statement
            val signal = body.execute(context)

            if (signal == ExecutionSignal.BreakIteration) break
            if (signal is ExecutionSignal.Return) return signal
            // Continue signal will work properly naturally.
        }

        return ExecutionSignal.NormalOperation
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "condition" to condition,
        "body" to body,
    )
}