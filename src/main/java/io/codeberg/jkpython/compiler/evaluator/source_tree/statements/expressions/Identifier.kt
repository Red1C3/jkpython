package io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions

import io.codeberg.jkpython.compiler.evaluator.core.Context
import io.codeberg.jkpython.compiler.evaluator.core.PyObject

class Identifier(
    val name: String,
) : Expression(listOf()) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this);
//    }
    override fun evaluate(context: Context): PyObject = context.lookupVariable(name)

    override fun getPrintableFields(): HashMap<String, Any?> {
        return hashMapOf("name" to name)
    }
}