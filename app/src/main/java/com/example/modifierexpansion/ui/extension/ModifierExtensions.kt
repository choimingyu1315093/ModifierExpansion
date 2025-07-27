package com.example.modifierexpansion.ui.extension

import androidx.compose.ui.Modifier

class ConditionalModifierBuilder(
    private val modifier: Modifier,
    private val condition: Boolean
) {
    private var trueModifier: Modifier = modifier
    private var falseModifier: Modifier = modifier

    fun ifTrue(block: Modifier.() -> Modifier): ConditionalModifierBuilder {
        if (condition) {
            trueModifier = modifier.block()
        }
        return this
    }

    fun ifFalse(block: Modifier.() -> Modifier): Modifier {
        if (!condition) {
            falseModifier = modifier.block()
        }
        return if (condition) trueModifier else falseModifier
    }
}

fun Modifier.conditional(condition: Boolean): ConditionalModifierBuilder {
    return ConditionalModifierBuilder(this, condition)
}