package evaluator.calculator_06.source_tree

import evaluator.calculator_06.core.ExplorerSignal
import evaluator.calculator_06.core.ExplorerSignal.*

abstract class SourceNode(
    val children: List<SourceNode>
) {
    fun explore(
        explorer: (node: SourceNode) -> ExplorerSignal
    ): ExplorerSignal {
        val signal = explorer(this)
        if (signal !== CONTINUE) return signal

        for (child in children) {
            val childSignal = child.explore(explorer)
            if (childSignal === STOP) return childSignal
        }

        return CONTINUE
    }
}