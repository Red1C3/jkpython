package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.types.PyBool
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.expressions.Expression
import compiler.evaluator.visualization.AST
import compiler.evaluator.visualization.LabeledEdge

class WhileStatement(
        private val condition: Expression,
        private val block: StatementsBlock
        ):Statement() {
    init{
        AST.instance().g.addVertex(this)
        AST.instance().g.addEdge(this,condition,LabeledEdge("cond"))
        AST.instance().g.addEdge(this,block,LabeledEdge())
    }
    override fun execute(context: Context): ExecutionSignal {
        // Evaluate the condition expression until it returns false
        while((condition.evaluate(context) as PyBool).value){ //TODO handle floats and string conditions
            // Execute the statements block each loop unless it faces a break statement
            val signal = block.execute(context)
            if(signal==ExecutionSignal.BreakOperation) break
            if(signal is ExecutionSignal.Return) return signal
        }
        return ExecutionSignal.NormalOperation
    }

    override fun toString(): String {
        return "while stmt"
    }
}