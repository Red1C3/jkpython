package evaluator.calculator_06.source_tree.statements.expressions

import evaluator.calculator_06.core.Context
import evaluator.calculator_06.core.PyCallable
import evaluator.calculator_06.core.PyObject

class FunctionCall(
    private val id: Identifier,
    private val parameters: List<Expression>,
): Expression(listOf(id) + parameters) {
    override fun evaluate(context: Context): PyObject {
        val function = context.lookupVariable(id.name)
        val parametersValues = parameters.map { it.evaluate(context) }

        // TODO: throw proper python exception with a standard message format.
        if (function !is PyCallable) error("'${function.javaClass.name}' object is not callable")

        return function.call(context, parametersValues)
    }
}