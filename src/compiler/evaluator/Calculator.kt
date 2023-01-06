package compiler.evaluator

import compiler.evaluator.core.StandardContext
import compiler.evaluator.source_tree.statements.expressions.*
import compiler.evaluator.source_tree.Program
import compiler.evaluator.source_tree.statements.FunctionDeclaration
import compiler.evaluator.source_tree.statements.ReturnStatement
import compiler.evaluator.source_tree.statements.StatementsBlock

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
                    InfixExpression(
                        Identifier("side"),
                        "*",
                        Identifier("side"),
                    )
                )
            )
        ),

        // a_side = 5
        AssignmentExpression(
            Identifier("a_side"),
                null,
            Literal(5.0),
        ),

        // space = calc_space(a_side)
        AssignmentExpression(
            Identifier("space"),
                null,
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

fun createArithTest(): Program {
    return Program(StatementsBlock(
            FunctionCall(Identifier("print"), listOf(
                    InfixExpression(Literal(1.0),"+", Literal(2.0))
            ))
    ))
}

fun main() {
    val program = createArithTest()
    val context = StandardContext()

    program.run(context)
}