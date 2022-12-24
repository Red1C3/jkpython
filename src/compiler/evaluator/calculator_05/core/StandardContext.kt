package evaluator.calculator_05.core

import evaluator.calculator_05.builtins.functions.PyPrint

class StandardContext : Context() {
    init {
        setVariable("print", PyPrint)
    }
}