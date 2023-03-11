package io.codeberg.jkpython.compiler.evaluator.source_tree

import io.codeberg.jkpython.compiler.evaluator.builtins.types.PyString
import io.codeberg.jkpython.compiler.evaluator.core.VisitorSignal
import io.codeberg.jkpython.compiler.evaluator.core.VisitorSignal.*

abstract class SourceNode(
    val children: List<SourceNode>
) {
    private var metaInfoHasBeenSet = false

    var line: Int? = null
        private set
    var column: Int? = null
        private set
    var fileName: String? = null
        private set

    fun explore(
        visitor: (node: SourceNode) -> VisitorSignal
    ): VisitorSignal {
        val signal = visitor(this)
        if (signal !== CONTINUE) return signal

        for (child in children) {
            val childSignal = child.explore(visitor)
            if (childSignal === STOP) return childSignal
        }

        return CONTINUE
    }

    protected abstract fun getPrintableFields(): HashMap<String, Any?>

    override fun toString(): String {
        val name = this::class.simpleName!!
        var location = ""

        line?.let { location = "$line$location" }
        column?.let { location = "$location:$column" }
        if (location.isNotEmpty()) location = " [$location]"
        if (location.isEmpty() && fileName !== null) location = " <$fileName>"

        var body = ""
        val printableFields = getPrintableFields()
        if (printableFields.isNotEmpty()) {
            body = printableFields.filterValues { it !== null }.toList().joinToString("\n") { (key, value) ->
                val formattedValue = when (value) {
                    is String, is PyString -> "\"$value\""
                    is Char -> "'$value'"
                    is List<*> -> {
                        if (value.size == 1) "[ ${value.first()} ]"
                        else "[\n${value.joinToString("\n") { "- $it".prependIndent("\t") }}\n]"
                    }

                    else -> "$value"
                }

                "$key: $formattedValue"
            }

            body = if (!body.contains("\n")) " { $body }"
            else " {\n${body.prependIndent("\t")}\n}"
        }

        return "$name$location$body"
    }

    companion object {
        fun <T : SourceNode> addMeta(
            node: T, line: Int? = null,
            column: Int? = null,
            fileName: String? = null,
        ): T {
            if (node.metaInfoHasBeenSet) throw Error("The meta-information has been already set")

            node.line = line
            node.column = column
            node.fileName = fileName

            return node
        }
    }
}