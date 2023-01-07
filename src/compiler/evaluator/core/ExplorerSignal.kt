package compiler.evaluator.core

/**
 * Used to control the exploration process when traversing a source-tree.
 */
enum class ExplorerSignal {
    /**
     * Continue exploring the source-tree normally.
     */
    CONTINUE,

    /**
     * Continue exploring the source-tree but skip the children of this node.
     */
    SKIP_CHILDREN,

    /**
     * Stop the exploration process.
     */
    STOP,
}