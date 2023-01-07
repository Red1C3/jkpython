package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject

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