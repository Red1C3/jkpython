package io.codeberg.jkpython.compiler.evaluator.builtins.types

import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNone
import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.StatementsBlock
import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions.Identifier
import io.codeberg.jkpython.compiler.evaluator.core.*

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