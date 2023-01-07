package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject

// TODO: Find a more universal solution for figuring out the variable slot to use.

class AssignmentExpression(
        val target: Identifier,
        private val expression: Expression,
        private val index: Expression? = null,
) : Expression(listOf(target, expression)) {

    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this,target,LabeledEdge())
//        if(index!=null)
//            AST.instance().g.addEdge(this,index, LabeledEdge("index"))
//        AST.instance().g.addEdge(this,expression,LabeledEdge())
//    }

    override fun evaluate(context: Context): PyObject {
        if (index == null) {
            // Normal assignment (a = 2)
            val result = expression.evaluate(context)
            context.setVariable(target.name, result)
            return result
        } else {
            // TODO (rami): review lists code.

            // List element assignment ( a[0] = 2 )
            val result = expression.evaluate(context)
            val list = target.evaluate(context) as PyList
            val indexValue = (index.evaluate(context) as PyFloat).value.toInt()
            // if (indexValue >= list.size())
            // FIXME: Throw out of bound errors

            list[indexValue] = result //Store the evaluated expression in the list
            return result
        }
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "target" to target,
        "expression" to expression,
    )
}