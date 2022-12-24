package evaluator.calculator_06.source_tree.statements.expressions

import evaluator.calculator_06.core.Context
import evaluator.calculator_06.core.PyObject
import evaluator.calculator_06.source_tree.SourceNode

class Identifier(
    val name: String,
) : Expression(listOf()) {
    override fun evaluate(context: Context): PyObject = context.lookupVariable(name)
}