package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject

// TODO (rami): review lists code.

//Like this [1,2,'meow',True,functionCall()]
class ListExpression(
    private val values: List<Expression>
) : Expression(values) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        for (exp in values)
//            AST.instance().g.addEdge(this, exp, LabeledEdge(""))
//    }

    override fun evaluate(context: Context): PyObject {
        return PyList(values.map { it.evaluate(context) }.toMutableList())
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "values" to values
    )
}