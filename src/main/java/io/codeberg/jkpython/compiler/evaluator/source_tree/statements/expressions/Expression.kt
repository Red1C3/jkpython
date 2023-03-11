package io.codeberg.jkpython.compiler.evaluator.source_tree.statements.expressions

import io.codeberg.jkpython.compiler.evaluator.core.Context
import io.codeberg.jkpython.compiler.evaluator.core.ExecutionSignal
import io.codeberg.jkpython.compiler.evaluator.core.PyObject
import io.codeberg.jkpython.compiler.evaluator.source_tree.SourceNode
import io.codeberg.jkpython.compiler.evaluator.source_tree.statements.Statement

abstract class Expression(children: List<SourceNode>) : Statement(children) {
    abstract fun evaluate(context: Context): PyObject

    /**
     * Expressions can be executed as normal statements, but their value would be discarded.
     */
    final override fun execute(context: Context): ExecutionSignal {
        evaluate(context)
        return ExecutionSignal.NormalOperation
    }
}