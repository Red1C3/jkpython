package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.PyCallable
import compiler.evaluator.core.PyObject

// FIXME: Function call should take an expression instead of an id.

class FunctionCall(
        private val id: Identifier,
        private val parameters: List<Expression>,
): Expression(listOf(id) + parameters) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this,id,LabeledEdge("Func"))
//        for (param in parameters){
//            AST.instance().g.addEdge(this,param,LabeledEdge("Arg"))
//        }
//    }

    override fun evaluate(context: Context): PyObject {
        val function = context.lookupVariable(id.name)
        val parametersValues = parameters.map { it.evaluate(context) }

        // TODO: throw proper python exception with a standard message format.
        if (function !is PyCallable) error("'${function.javaClass.name}' object is not callable")

        return function.call(parametersValues)
    }

    override fun getPrintableFields(): HashMap<String, Any?> {
        return hashMapOf(
            "id" to id,
            "parameters" to parameters,
        )
    }
}