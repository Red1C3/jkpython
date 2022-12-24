package evaluator.calculator_06.core

import evaluator.calculator_06.builtins.functions.PyPrint

class StandardContext : Context() {
    init {
        setVariable("print", PyPrint)
    }
}