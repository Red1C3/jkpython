package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject
import compiler.evaluator.source_tree.statements.expressions.Expression
import compiler.evaluator.visualization.AST

class Identifier(
    val name: String,
) : Expression() {
    init {
        AST.instance().g.addVertex(this);
    }
    override fun evaluate(context: Context): PyObject = context.lookupVariable(name)
    public override fun toString(): String {
        return name
    }
}