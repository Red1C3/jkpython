package compiler.evaluator

import compiler.evaluator.core.BuiltinsContext
import compiler.evaluator.source_tree.statements.expressions.*
import compiler.evaluator.source_tree.Program
import compiler.evaluator.source_tree.SourceNode.Companion.addMeta
import compiler.evaluator.source_tree.statements.FunctionDeclaration
import compiler.evaluator.source_tree.statements.ReturnStatement
import compiler.evaluator.source_tree.statements.StatementsBlock

fun createTestingProgram(): Program {
    return addMeta(Program(
        StatementsBlock(
            /*
            def calc_space(side):
                return side * side
             */
            addMeta(FunctionDeclaration(
                addMeta(Identifier("calc_space"), 1, 5),
                // Parameters
                listOf(
                    addMeta(Identifier("side"), 1, 16)
                ),
                // Body Statements
                StatementsBlock(
                    addMeta(ReturnStatement(
                        addMeta(InfixExpression(
                            addMeta(Identifier("side"), 2, 12),
                            "*",
                            addMeta(Identifier("side"), 2, 19),
                        ), 2, 12)
                    ), 2, 5)
                )
            ), 1, 1),

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
        )
    ), fileName = "calc_space.py")
}

fun main() {
    val program = createTestingProgram()
    val context = BuiltinsContext()

    program.run(context)

    println()
    println("Source Tree:")
    println("------------")
    println()
    println(program)
}