package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject

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