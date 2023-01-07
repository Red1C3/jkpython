package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject
import compiler.evaluator.visualization.AST
import compiler.evaluator.visualization.LabeledEdge

//Evaluates indexed values like list[0]
class IndexExpression(
        private val index:Expression,
        private val identifier: Identifier //The list identifier
):Expression() {
    init {
        AST.instance().g.addVertex(this)
        AST.instance().g.addEdge(this,index,LabeledEdge("index"))
        AST.instance().g.addEdge(this,identifier,LabeledEdge())
    }
    override fun evaluate(context: Context): PyObject {
        val list=identifier.evaluate(context) as PyList
        //TODO check if integer and internal PyObject is correct
        val indexValue= (index.evaluate(context) as PyFloat).value.toInt()
        return list[indexValue]
    }

    override fun toString(): String {
        return "[]"
    }
}