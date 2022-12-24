package evaluator.calculator_05.source_tree.statements.expressions

import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.PyObject

class Identifier(
    val name: String,
) : Expression() {
    override fun evaluate(context: Context): PyObject = context.lookupVariable(name)
}