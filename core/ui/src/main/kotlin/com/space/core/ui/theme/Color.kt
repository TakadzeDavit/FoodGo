package com.space.core.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal object Colors {
    val Primary = Color(0xFF378ADD)
    val OnPrimary = Color(0xFFDEDEDE)
    val BadgeRed = Color(0xFFE24B4A)
    val AddedGreenText = Color(0xFF2D9D78)
    val AddedGreenBg = Color(0xFFE6F4EA)
    val TextPrimary = Color(0xFF0F1521)
    val TextSecondary = Color(0xFF6B7280)
    val Background = Color(0xFFF3F4F6)
    val CardBg = Color(0xFFFFFFFF)
    val Surface = Color(0xFFE1E1E1)
    val BorderNeutral = Color(0xFFE5E7EB)
}

data class FoodGoAppColors(
    val primary: Color,
    val onPrimary: Color,
    val surface: Color,
    val badgeRed: Color,
    val addedGreenText: Color,
    val addedGreenBg: Color,
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
    addedGreenText = Colors.AddedGreenText,
    addedGreenBg = Colors.AddedGreenBg,
    textPrimary = Colors.TextPrimary,
    textSecondary = Colors.TextSecondary,
    background = Colors.Background,
    cardBg = Colors.CardBg,
    borderNeutral = Colors.BorderNeutral
)

val LocalFoodGoColors = staticCompositionLocalOf<FoodGoAppColors> {
    error("No FoodGoAppColors colors provided")
}