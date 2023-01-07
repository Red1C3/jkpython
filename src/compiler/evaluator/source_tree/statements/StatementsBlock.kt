package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.Statement
import compiler.evaluator.visualization.AST
import compiler.evaluator.visualization.LabeledEdge
import compiler.evaluator.visualization.SymbolTable

class StatementsBlock(
    private vararg val statements: Statement
): Statement() {
    init{
        AST.instance().g.addVertex(this)
        for(stmt in statements){
            AST.instance().g.addEdge(this,stmt,LabeledEdge())
        }
    }
    override fun execute(context: Context): ExecutionSignal {
        for (statement in statements) {
            val signal = statement.execute(context)

            SymbolTable.instance().print()

            if (signal !== ExecutionSignal.NormalOperation)
                return signal
        }

        return ExecutionSignal.NormalOperation
    }

    override fun toString(): String {
        return "block"
    }
}