package evaluator.calculator_05.source_tree.statements.expressions

import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.PyCallable
import evaluator.calculator_05.core.PyObject

class FunctionCall(
    private val id: Identifier,
    private val parameters: List<Expression>,
): Expression() {
    override fun evaluate(context: Context): PyObject {
        val function = context.lookupVariable(id.name)
        val parametersValues = parameters.map { it.evaluate(context) }

        // TODO: throw proper python exception with a standard message format.
        if (function !is PyCallable) error("'${function.javaClass.name}' object is not callable")

        return function.call(context, parametersValues)
    }
}