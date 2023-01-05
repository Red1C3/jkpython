package compiler.evaluator.source_tree.statements.expressions

import compiler.evaluator.builtins.types.PyFloat
import compiler.evaluator.builtins.types.PyList
import compiler.evaluator.core.Context
import compiler.evaluator.core.PyObject

//Evaluates indexed values like list[0]
class IndexExpression(
        private val index:Literal,
        private val identifier: Identifier //The list identifier
):Expression() {
    override fun evaluate(context: Context): PyObject {
        val list=identifier.evaluate(context) as PyList
        //TODO check if integer and internal PyObject is correct
        val indexValue= (index.evaluate(context) as PyFloat).value.toInt()
        return list[indexValue]
    }
}