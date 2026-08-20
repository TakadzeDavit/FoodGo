package com.space.core.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal object Colors {
    val Primary = Color(0xFF3B7683)
    val OnPrimary = Color(0xFFFFFFFF)
    val Background = Color(0xFFF6F6EE)
    val CardBg = Color(0xFFEBDDC8)
    val TextPrimary = Color(0xFF265053)
    val TextSecondary = Color(0xFF0C6758)
    val BadgeRed = Color(0xFFB15053)
    val BorderNeutral = Color(0xFF0C6758)
    val AddedBg = Color(0xFFEBDDC8)
    val AddedText = Color(0xFF265053)
    val Surface = Color(0xFFF6F6EE)
}

data class FoodGoAppColors(
    val primary: Color,
    val onPrimary: Color,
    val surface: Color,
    val badgeRed: Color,
    val addedText: Color,
    val addedBg: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val background: Color,
    val cardBg: Color,
    val borderNeutral: Color,
)

val FoodGoColors = FoodGoAppColors(
    primary = Colors.Primary,
    onPrimary = Colors.OnPrimary,
    surface = Colors.Surface,
    badgeRed = Colors.BadgeRed,
    addedText = Colors.AddedText,
    addedBg = Colors.AddedBg,
    textPrimary = Colors.TextPrimary,
    textSecondary = Colors.TextSecondary,
    background = Colors.Background,
    cardBg = Colors.CardBg,
    borderNeutral = Colors.BorderNeutral
)

val LocalFoodGoColors = staticCompositionLocalOf<FoodGoAppColors> {
    error("No FoodGoAppColors colors provided")
}