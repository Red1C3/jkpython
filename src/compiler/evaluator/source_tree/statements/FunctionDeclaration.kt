package compiler.evaluator.source_tree.statements

import compiler.evaluator.core.Context
import compiler.evaluator.builtins.types.PyFunction
import compiler.evaluator.core.ExecutionSignal
import compiler.evaluator.core.Scope
import compiler.evaluator.core.SubScoped
import compiler.evaluator.source_tree.statements.expressions.Identifier

class FunctionDeclaration(
        val id: Identifier,
        private val parametersNames: List<Identifier>,
        private val body: StatementsBlock,
): Statement(listOf(id) + parametersNames + listOf(body)), SubScoped {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this,id, LabeledEdge("Func"))
//        AST.instance().g.addEdge(this,body, LabeledEdge())
//        for (param in parametersNames){
//            AST.instance().g.addEdge(this,param, LabeledEdge("Arg"))
//        }
//    }

    override val scope = Scope(this, parametersNames.map{ it.name })
    override fun execute(context: Context): ExecutionSignal {
        context.setVariable(id.name, PyFunction(id, scope, parametersNames, body, context))
        return ExecutionSignal.NormalOperation
    }

    override fun getPrintableFields(): HashMap<String, Any?> {
        return hashMapOf(
            "id" to id,
            "parameters" to parametersNames,
            "body" to body,
            "symbols" to scope,
        )
    }
}