package evaluator.calculator_05.source_tree.statements

import evaluator.calculator_05.core.Context
import evaluator.calculator_05.builtins.types.PyFunction
import evaluator.calculator_05.core.ExecutionSignal
import evaluator.calculator_05.source_tree.statements.expressions.Expression
import evaluator.calculator_05.source_tree.statements.expressions.Identifier

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