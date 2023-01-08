package compiler.evaluator.core

import compiler.evaluator.builtins.constants.PyNone

/**
 * Used by statements to alter the execution flow.
 * Used for returning from a function, breaking from a loop or skipping to the next loop iteration.
 */
open class ExecutionSignal private constructor() {
    /**
     * Keep the execution flowing normally.
     */
    object NormalOperation : ExecutionSignal()

    /**
     * Break to execution of a loop statement.
     */
    object BreakIteration : ExecutionSignal()

    /**
     * Skip the current iteration of a loop statement.
     */
    object ContinueIteration: ExecutionSignal()

    /**
     * Stop the execution of the current function and return a value.
     */
    class Return(val value: PyObject = PyNone) : ExecutionSignal()
}

