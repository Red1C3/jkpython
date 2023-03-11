package io.codeberg.jkpython.compiler.evaluator.source_tree.statements

import io.codeberg.jkpython.compiler.evaluator.core.Context
import io.codeberg.jkpython.compiler.evaluator.core.ExecutionSignal
import io.codeberg.jkpython.compiler.evaluator.source_tree.SourceNode

abstract class Statement(children: List<SourceNode>) : SourceNode(children) {
    abstract fun execute(context: Context): ExecutionSignal
}