package com.space.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.space.core.ui.theme.FoodGoColors

@Composable
fun FoodGoTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalFoodGoColors provides FoodGoColors,
        LocalFoodGoTypography provides FoodGoTypography
    ) {
        MaterialTheme(
            colorScheme = darkColorScheme(
                primary = FoodGoColors.primary,
                background = FoodGoColors.background,
            ),
            content = content
        )
    }
}

object FoodGoTheme {
    val colors: FoodGoAppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalFoodGoColors.current

    val typography: FoodGoAppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalFoodGoTypography.current
}