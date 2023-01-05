package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.types.PyBool
import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyString
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.expressions.Expression

class IfStatement(
        private val condition: Expression,
        private val block: StatementsBlock,
        private val elseifs:List<Pair<Expression, StatementsBlock>>, //All else ifs statements
        private val lastElse: StatementsBlock?
        ): Statement() {
    //Side note: when defining variables inside ifs in python they are
    //defined in the surrounding scope, hence, no need to a local scope
    override fun execute(context: Context): ExecutionSignal {
        var conditionValue=condition.evaluate(context);
        if(conditionSatisfied(conditionValue)){
            return block.execute(context) //Will only execute this block and return
        }
        for(elseif in elseifs){
            conditionValue=elseif.first.evaluate(context)
            if(conditionSatisfied(conditionValue)){
                return elseif.second.execute(context) //Will only execute this block and return
            }
        }
        if(lastElse!=null){
            return lastElse.execute(context) //Will only execute this block and return
        }
        return  ExecutionSignal.NormalOperation //No condition was satisfied and there was no final else
    }
    //Evaluates each data type to a boolean
    private fun conditionSatisfied(condition: PyObject) : Boolean{
        return ((condition is PyBool) && condition.value)||
                ((condition is PyFloat)&&condition.value!=0.0)||
                ((condition is PyString) && condition.value.isNotEmpty())
    }
}