package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.expressions.Expression

class Identifier(
    val name: String,
) : Expression() {
    override fun evaluate(context: Context): PyObject = context.lookupVariable(name)
}