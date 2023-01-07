package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.Statement
import compiler.evaluator.visualization.AST

//Will break any block (even outside of for loops)
class BreakStatement :Statement() {
    init{
        AST.instance().g.addVertex(this)
    }
    override fun execute(context: Context): ExecutionSignal {
        return ExecutionSignal.BreakOperation
    }

    override fun toString(): String {
        return "break"
    }
}