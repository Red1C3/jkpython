package compiler.evaluator.builtins.types

import compiler.evaluator.builtins.constants.PyNone
import compiler.evaluator.core.*
import compiler.evaluator.source_tree.statements.StatementsBlock
import compiler.evaluator.source_tree.statements.expressions.Identifier

class PyFunction(
    private val id: Identifier, //TODO: Use the id in errors reporting.
    private val scope: Scope,
    private val parametersNames: List<Identifier>,
    private val body: StatementsBlock,
    private val declarationContext: Context,
) : PyCallable {

    override fun __repr__(): PyString = PyString(
        "<function ${id.name} with hash 0x${
            hashCode().toString(16).uppercase()
        }>"
    )

    override fun call(arguments: List<PyObject>): PyObject {
        // A sub scope of the function declaration scope
        val subContext = declarationContext.createSubContext(scope)

        // Provide the parameters
        (parametersNames zip arguments).forEach { (id, value) ->
            subContext.setVariable(id.name, value)
        }

        val resultSignal = body.execute(subContext)
        if (resultSignal is ExecutionSignal.Return)
            return resultSignal.value

        return PyNone
    }
}