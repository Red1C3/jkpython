package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.visualization.AST

//Will skip any block even outside a for loop (yes that's a bug)
class ContinueStatement:Statement() {
    init {
        AST.instance().g.addVertex(this)
    }
    override fun execute(context: Context): ExecutionSignal {
        return ExecutionSignal.ContinueOperation
    }

    override fun toString(): String {
        return "continue"
    }
}