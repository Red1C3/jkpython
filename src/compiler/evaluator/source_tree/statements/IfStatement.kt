package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.types.PyBool
import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyString
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.expressions.Expression

//Evaluates each data type to a boolean
fun isConditionSatisfied(condition: PyObject): Boolean {
    return ((condition is PyBool) && condition.value) ||
            ((condition is PyFloat) && condition.value != 0.0) ||
            ((condition is PyString) && condition.value.isNotEmpty())
}

class IfStatement(
        private val condition: Expression,
        private val body: StatementsBlock,
        private val elseIfs: List<Pair<Expression, StatementsBlock>> = listOf(), //All else ifs statements
        private val elseBody: StatementsBlock? = null,
) : Statement(listOf(condition, body) + elseIfs.map { it.toList() }.flatten() + (elseBody?.let { listOf(it) }
    ?: listOf())) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this, condition, LabeledEdge("cond"))
//        AST.instance().g.addEdge(this, block, LabeledEdge())
//        for (elseif in elseifs) {
//            AST.instance().g.addEdge(this, elseif.first, LabeledEdge("elif-cond"))
//            AST.instance().g.addEdge(this, elseif.second, LabeledEdge("elif-block"))
//        }
//        if (lastElse != null)
//            AST.instance().g.addEdge(this, lastElse, LabeledEdge("else"))
//    }

    //Side note: when defining variables inside ifs in python they are
    //defined in the surrounding scope, hence, no need to a local scope
    override fun execute(context: Context): ExecutionSignal {
        var conditionValue = condition.evaluate(context)
        if (isConditionSatisfied(conditionValue)) return body.execute(context)

        for (elseif in elseIfs) {
            conditionValue = elseif.first.evaluate(context)
            if (isConditionSatisfied(conditionValue)) return elseif.second.execute(context)
        }

        if (elseBody != null) return elseBody.execute(context)

        return ExecutionSignal.NormalOperation // No condition was satisfied and there was no final else
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "condition" to condition,
        "body" to body,
        "elseIfs" to elseIfs,
        "else" to elseBody,
    )
}