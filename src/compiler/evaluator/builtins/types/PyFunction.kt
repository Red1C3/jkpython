package compiler.evaluator.builtins.types

import compiler.evaluator.builtins.constants.PyNone
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.StatementsBlock
import compiler.evaluator.source_tree.statements.expressions.Identifier

class PyFunction(
        private val id: Identifier, //TODO: Use the id in errors reporting.
        private val parametersNames: List<Identifier>,
        private val body: StatementsBlock,
) : PyCallable {
    override fun call(context: Context, arguments: List<PyObject>): PyObject {
        val subContext = context.createSubContext()
        (parametersNames zip arguments).forEach {
            val (parameterId, parameterValue) = it
            subContext.setVariable(parameterId.name, parameterValue)
        }

        val resultSignal = body.execute(subContext)
        if (resultSignal is ExecutionSignal.Return)
            return resultSignal.value

        return PyNone
    }
}