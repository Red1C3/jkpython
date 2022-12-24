package evaluator.calculator_06

import evaluator.calculator_06.core.StandardContext
import evaluator.calculator_06.source_tree.Program
import evaluator.calculator_06.source_tree.statements.expressions.AssignmentExpression
import evaluator.calculator_06.source_tree.statements.FunctionDeclaration
import evaluator.calculator_06.source_tree.statements.ReturnStatement
import evaluator.calculator_06.source_tree.statements.StatementsBlock
import evaluator.calculator_06.source_tree.statements.expressions.*

fun createTestingProgram(): Program {
    return Program(StatementsBlock(
        /*
        def calc_space(side):
            return side * side
         */
        FunctionDeclaration(
            Identifier("calc_space"),
            // Parameters
            listOf(
                Identifier("side")
            ),
            // Body Statements
            StatementsBlock(
                ReturnStatement(
                    ArithmeticExpression(
                        Identifier("side"),
                        '*',
                        Identifier("side"),
                    )
                )
            )
        ),

        // a_side = 5
        AssignmentExpression(
            Identifier("a_side"),
            Literal(5.0),
        ),

        // space = calc_space(a_side)
        AssignmentExpression(
            Identifier("space"),
            FunctionCall(
                Identifier("calc_space"),
                listOf(Identifier("a_side"))
            )
        ),

        // print("space =", space)
        FunctionCall(
            Identifier("print"),
            listOf(
                Literal("space ="),
                Identifier("space"),
            )
        ),
    ))
}

fun main() {
    val program = createTestingProgram()
    val context = StandardContext()

    program.run(context)
}