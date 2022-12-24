package evaluator.calculator_05.core

/**
 * This was not designed as a special method on `PyObject` because the builtin python function `callable`
 * should be able to tell if an object is callable or not, and that could be done using the Kotlin `is` operator.
 */
interface PyCallable : PyObject {
    fun call(context: Context, arguments: List<PyObject> = listOf()): PyObject
}