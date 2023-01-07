package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.core.ExecutionSignal.NormalOperation

class StatementsBlock(
    private vararg val statements: Statement
) : Statement(statements.toList()) {
    override fun execute(context: Context): ExecutionSignal {
        for (statement in statements) {
            val signal = statement.execute(context)
            if (signal !== NormalOperation)
                return signal
        }

        return NormalOperation
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf()

    override fun toString(): String {
        return "StatementsBlock {\n${
            statements.joinToString("\n\n") { "* $it" }.prependIndent("\t")
        }\n}"
    }
}