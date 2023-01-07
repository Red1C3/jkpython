package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject
import compiler.evaluator.visualization.AST
import compiler.evaluator.visualization.LabeledEdge

//Like this [1,2,'meow',True,functionCall()]
class ListExpression(
        private val expressions:List<Expression>
): Expression() {
    init {
        AST.instance().g.addVertex(this)
        for(exp in expressions)
            AST.instance().g.addEdge(this,exp,LabeledEdge(""))
    }
    override fun evaluate(context: Context): PyObject {
        val literals=ArrayList<PyObject>()
        for(expression in expressions){
            literals.add(expression.evaluate(context)) //Evaluate each list member to a literal
        }
        return PyList(literals) //Host lang list container
    }

    override fun toString(): String {
        return "[]"
    }
}