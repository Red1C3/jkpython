package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject
import compiler.evaluator.visualization.*

class AssignmentExpression(
        private val target: Identifier,
        private val index: Expression?,
        private val expression: Expression,
) : Expression() {
    init {
        AST.instance().g.addVertex(this)
        AST.instance().g.addEdge(this,target,LabeledEdge())
        if(index!=null)
            AST.instance().g.addEdge(this,index, LabeledEdge("index"))
        AST.instance().g.addEdge(this,expression,LabeledEdge())
    }
    override fun evaluate(context: Context): PyObject {
        if (index == null) {
            //Normal assignment aka a=2
            val result = expression.evaluate(context)
            context.setVariable(target.name, result)
            return result
        } else {
            //List element assignment aka a[0]=2
            val result = expression.evaluate(context)
            val list = target.evaluate(context) as PyList
            val indexValue = (index.evaluate(context) as PyFloat).value.toInt()
            if (indexValue >= list.size()){
                //TODO throw an error
            }
            list[indexValue] = result //Store the evaluated expression in the list
            return result
        }
    }

    public override fun toString(): String {
        return "="
    }
}