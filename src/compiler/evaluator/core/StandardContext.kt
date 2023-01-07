package compiler.evaluator.core

import compiler.evaluator.builtins.functions.PyAppend
import compiler.evaluator.builtins.functions.PyPrint
import compiler.evaluator.builtins.functions.PyRange
import compiler.evaluator.core.Context
import compiler.evaluator.visualization.SymbolTable

class StandardContext : Context() {
    init {
        setVariable("print", PyPrint)
        setVariable("range",PyRange)
        setVariable("append",PyAppend)
        SymbolTable.instance().addContext(this)
    }
}