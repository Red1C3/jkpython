package compiler.evaluator.source_tree.statements

import compiler.evaluator.builtins.types.PyBool
import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyString
import compiler.evaluator.core.Context
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.expressions.Expression
import compiler.evaluator.visualization.AST
import compiler.evaluator.visualization.LabeledEdge

class IfStatement(
        private val condition: Expression,
        private val block: StatementsBlock,
        private val elseifs:List<Pair<Expression, StatementsBlock>>, //All else ifs statements
        private val lastElse: StatementsBlock?
        ): Statement() {
    init {
        AST.instance().g.addVertex(this)
        AST.instance().g.addEdge(this,condition,LabeledEdge("cond"))
        AST.instance().g.addEdge(this,block,LabeledEdge())
        for (elseif in elseifs){
            AST.instance().g.addEdge(this,elseif.first,LabeledEdge("elif-cond"))
            AST.instance().g.addEdge(this,elseif.second,LabeledEdge("elif-block"))
        }
        if (lastElse!=null)
            AST.instance().g.addEdge(this,lastElse,LabeledEdge("else"))
    }
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

    override fun toString(): String {
        return "if stmt"
    }
}