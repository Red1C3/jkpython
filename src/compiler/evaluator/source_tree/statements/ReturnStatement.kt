package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.constants.PyNone
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.expressions.Expression
import compiler.evaluator.source_tree.statements.expressions.Literal

class ReturnStatement(
    val value: Expression = Literal(PyNone)
) : Statement(listOf(value)) {
    // FIXME: commented AST code
//    init{
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this,value,LabeledEdge())
//    }
    override fun execute(context: Context): ExecutionSignal {
        return ExecutionSignal.Return(value.evaluate(context))
    }

    override fun getPrintableFields(): HashMap<String, Any?> {
        return hashMapOf("value" to value)
    }
}