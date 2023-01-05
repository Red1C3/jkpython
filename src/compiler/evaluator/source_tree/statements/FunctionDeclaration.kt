package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.builtins.types.PyFunction
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.expressions.Identifier

class FunctionDeclaration(
        private val id: Identifier,
        private val parametersNames: List<Identifier>,
        private val body: StatementsBlock,
): Statement() {
    override fun execute(context: Context): ExecutionSignal {
        context.setVariable(id.name, PyFunction(id, parametersNames, body))
        return ExecutionSignal.NormalOperation
    }
}