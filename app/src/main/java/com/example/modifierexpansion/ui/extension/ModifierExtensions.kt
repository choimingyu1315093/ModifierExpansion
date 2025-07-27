package com.example.modifierexpansion.ui.extension

import androidx.compose.ui.Modifier

class ConditionalModifierBuilder(
    private val base: Modifier,
    private val condition: Boolean
) {
    private var trueModifier: Modifier = base
    private var falseModifier: Modifier = base

    fun ifTrue(block: Modifier.() -> Modifier): ConditionalModifierBuilder {
        if (condition) {
            trueModifier = base.block()
        }
        return this
    }

    fun ifFalse(block: Modifier.() -> Modifier): Modifier {
        if (!condition) {
            falseModifier = base.block()
        }
        return if (condition) trueModifier else falseModifier
    }
}

fun Modifier.conditional(condition: Boolean): ConditionalModifierBuilder {
    return ConditionalModifierBuilder(this, condition)
}