package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject

// TODO (rami): review lists code.

//Evaluates indexed values like list[0]
class IndexExpression (
        private val target: Expression,
        private val index: Expression,
) : Expression(listOf(index, target)) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this, index, LabeledEdge("index"))
//        AST.instance().g.addEdge(this, identifier, LabeledEdge())
//    }

    override fun evaluate(context: Context): PyObject {
        val list = target.evaluate(context) as PyList
        // FIXME: check if integer and internal PyObject is correct
        val indexValue = (index.evaluate(context) as PyFloat).value.toInt()
        return list[indexValue]
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "target" to target,
        "index" to index,
    )
}