package evaluator.calculator_05.builtins.types

import evaluator.calculator_05.builtins.constants.PyNone
import evaluator.calculator_05.core.Context
import evaluator.calculator_05.core.ExecutionSignal
import evaluator.calculator_05.core.PyCallable
import evaluator.calculator_05.core.PyObject
import evaluator.calculator_05.source_tree.statements.StatementsBlock
import evaluator.calculator_05.source_tree.statements.expressions.Identifier

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