package io.codeberg.jkpython.compiler.evaluator.core

import io.codeberg.jkpython.compiler.evaluator.core.Scope

interface SubScoped {
    val scope: Scope
}