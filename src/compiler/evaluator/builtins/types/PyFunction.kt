package compiler.evaluator.builtins.types

import compiler.evaluator.builtins.constants.PyNone
import compiler.evaluator.core.*
import compiler.evaluator.source_tree.statements.StatementsBlock
import compiler.evaluator.source_tree.statements.expressions.Identifier

class PyFunction(
        private val id: Identifier, //TODO: Use the id in errors reporting.
        private val parametersNames: List<Identifier>,
        private val body: StatementsBlock,
        private val ctx:Context //Function declaration scope
) : PyCallable {
    override fun call(arguments: List<PyObject>): PyObject {
        val subContext = ctx.createSubContext() //A sub scope of the function declaration scope
        (parametersNames zip arguments).forEach {
            val (parameterId, parameterValue) = it
            subContext.setVariable(parameterId.name, parameterValue)
        }

        val resultSignal = body.execute(subContext)
        if (resultSignal is ExecutionSignal.Return)
            return resultSignal.value

        return PyNone
    }

    override fun toString(): String {
        return "Function"
    }
}