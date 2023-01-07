package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.builtins.types.PyFunction
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.core.StandardContext
import compiler.evaluator.source_tree.statements.expressions.Identifier
import compiler.evaluator.visualization.AST
import compiler.evaluator.visualization.LabeledEdge

class FunctionDeclaration(
        private val id: Identifier,
        private val parametersNames: List<Identifier>,
        private val body: StatementsBlock,
): Statement() {
    init {
        AST.instance().g.addVertex(this)
        AST.instance().g.addEdge(this,id,LabeledEdge("Func"))
        AST.instance().g.addEdge(this,body,LabeledEdge())
        for (param in parametersNames){
            AST.instance().g.addEdge(this,param,LabeledEdge("Arg"))
        }
    }
    override fun execute(context: Context): ExecutionSignal {
        context.setVariable(id.name, PyFunction(id, parametersNames, body,context))
        return ExecutionSignal.NormalOperation
    }

    override fun toString(): String {
        return "Function Declaration"
    }
}