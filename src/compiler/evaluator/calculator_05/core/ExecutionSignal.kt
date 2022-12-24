package evaluator.calculator_05.core

import evaluator.calculator_05.builtins.constants.PyNone

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
     * Stop the execution of the current function and return a value.
     */
    class Return(val value: PyObject = PyNone) : ExecutionSignal()
}

