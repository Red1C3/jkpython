package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.expressions.Expression
import compiler.evaluator.source_tree.statements.expressions.Identifier

// TODO (rami): Review how iterables are done.

class ForStatement(
         val iterator: Identifier, //The current loop value from the list
        private val iterable: Expression, //The list expression
        private val body: StatementsBlock, //for-loop block
) : Statement(listOf(iterator, iterable, body)) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this, iterator, LabeledEdge("iterator"))
//        AST.instance().g.addEdge(this, iterable, LabeledEdge("list exp"))
//        AST.instance().g.addEdge(this, body, LabeledEdge(""))
//    }

    // Side note: when defining variables inside loops in python they are
    // defined in the surrounding scope, hence, no need to a local scope
    override fun execute(context: Context): ExecutionSignal {
        val listVal = iterable.evaluate(context) as PyList // Evaluate the list 1st

        for (i in 0 until listVal.size()) { // loop over the list
            context.setVariable(iterator.name, listVal[i]) // Assign the current loop value in the new scope
            val signal = body.execute(context)

            if (signal === ExecutionSignal.BreakOperation) break
            if (signal is ExecutionSignal.Return) return signal
            // Continue signal will work properly naturally.
        }

        return ExecutionSignal.NormalOperation
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "iterator" to iterator,
        "iterable" to iterable,
        "body" to body,
    )
}