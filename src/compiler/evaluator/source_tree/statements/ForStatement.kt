package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.source_tree.statements.expressions.Expression
import compiler.evaluator.source_tree.statements.expressions.Identifier
import kotlin.math.sign

class ForStatement(
        private val iterator: Identifier, //The current loop value from the list
        private val iterable: Expression, //The list expression
        private val block: StatementsBlock //for-loop block
        ) :Statement(){
    //Side note: when defining variables inside loops in python they are
    //defined in the surrounding scope, hence, no need to a local scope
    override fun execute(context: Context): ExecutionSignal {
        val listVal=iterable.evaluate(context) as PyList //Evaluate the list 1st
        for(i in 0 until listVal.size()){ //loop over the list
            context.setVariable(iterator.name,listVal[i]) //Assign the current loop value in the new scope
            val signal=block.execute(context)
            if(signal===ExecutionSignal.BreakOperation) break
        }
        return ExecutionSignal.NormalOperation
    }
}