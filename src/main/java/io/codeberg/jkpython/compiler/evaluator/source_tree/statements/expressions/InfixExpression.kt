package io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions

import io.codeberg.jkpython.compiler.evaluator.builtins.constants.PyNotImplemented
import io.codeberg.jkpython.compiler.evaluator.core.Context
import io.codeberg.jkpython.compiler.evaluator.core.PyObject

class InfixExpression(
        private val firstOperand: Expression,
        private val operator: String,
        private val secondOperand: Expression,
) : Expression(listOf(firstOperand, secondOperand)) {
    // FIXME: commented AST code
//    init {
//        AST.instance().g.addVertex(this)
//        AST.instance().g.addEdge(this, firstOperand, LabeledEdge())
//        AST.instance().g.addEdge(this, secondOperand, LabeledEdge())
//    }
    override fun evaluate(context: Context): PyObject {
        val first = firstOperand.evaluate(context)
        val second = secondOperand.evaluate(context)

        val result = when (operator) {
            "+" -> first.__add__(second)
            "-" -> first.__sub__(second)
            "*" -> first.__mul__(second)
            "@" -> first.__matmul__(second) // TODO: Integrate with parser
            "/" -> first.__truediv__(second)
            "//" -> first.__floordiv__(second) // TODO: Integrate with parser
            "%" -> first.__mod__(second) // TODO: Integrate with parser
            "**" -> first.__pow__(second) // TODO: Integrate with parser
            "==" -> first.__eq__(second)
            "!=" -> first.__ne__(second)
            ">" -> first.__gt__(second)
            "<" -> first.__lt__(second)
            ">=" -> first.__ge__(second)
            "<=" -> first.__le__(second)
            "&&" -> first.and(second) // FIXME: Should be "and"
            "||" -> first.or(second)  // FIXME: Should be "or
            else -> error("Invalid infix operator: $operator")
        }

        if (result == PyNotImplemented) error("operation not implemented")
        return result
    }

    override fun getPrintableFields(): HashMap<String, Any?> = hashMapOf(
        "first" to firstOperand,
        "operator" to operator,
        "second" to secondOperand,
    )
}