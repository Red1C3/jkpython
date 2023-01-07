package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject
import compiler.evaluator.visualization.AST
import compiler.evaluator.visualization.LabeledEdge

//For operations with a single operator that precedes the expression, such as not
class PrefixExpression(
        private val operator:String,
        private val operand: Expression
): Expression() {
    init{
        AST.instance().g.addVertex(this)
        AST.instance().g.addEdge(this,operand,LabeledEdge())
    }
    override fun evaluate(context: Context): PyObject {
        val value=operand.evaluate(context)
        return when(operator){
            "!" -> value.not()
            else -> error("Unsupported prefix operator: $operator")
        }
    }

    override fun toString(): String {
        return operator
    }
}