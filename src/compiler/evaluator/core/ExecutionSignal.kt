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

    //Signal a break statement occurrence
    object BreakOperation:ExecutionSignal()

    //Signal a continue statement occurrence
    object ContinueOperation:ExecutionSignal()

    /**
     * Stop the execution of the current function and return a value.
     */
    class Return(val value: PyObject = PyNone) : ExecutionSignal()
}

