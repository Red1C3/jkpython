package evaluator.calculator_06.source_tree.statements

import evaluator.calculator_06.core.Context
import evaluator.calculator_06.builtins.types.PyFunction
import evaluator.calculator_06.core.ExecutionSignal
import evaluator.calculator_06.source_tree.statements.expressions.Identifier

class FunctionDeclaration(
    private val id: Identifier,
    private val parametersNames: List<Identifier>,
    private val body: StatementsBlock,
): Statement(listOf(id) + parametersNames + listOf(body)) {
    override fun execute(context: Context): ExecutionSignal {
        context.setVariable(id.name, PyFunction(id, parametersNames, body))
        return ExecutionSignal.NormalOperation
    }
}