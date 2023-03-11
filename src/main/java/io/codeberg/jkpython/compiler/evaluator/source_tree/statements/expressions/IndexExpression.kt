package io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions

import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyFloat
import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyList
import io.codeberg.jkpython.compiler.evaluator.core.Context
import io.codeberg.jkpython.compiler.evaluator.core.PyObject

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