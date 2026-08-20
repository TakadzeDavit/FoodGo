package com.space.foodgo.feature.menu.presentation.component.filter

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.space.core.ui.theme.FoodGoTheme
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Radius
import com.space.core.ui.theme.Sizing
import com.space.core.ui.theme.Spacing
import com.space.core.ui.theme.TextSizing

@Composable
fun FilterChipItem(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) colors.background else colors.addedBg
    )
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) colors.addedBg else colors.background
    )
    val borderColor = if (isSelected) Color.Transparent else colors.addedBg

    Box(
        modifier = Modifier
            .clip(Radius.Radius50)
            .background(backgroundColor)
            .border(
                Sizing.size2, borderColor,
                Radius.Radius50
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = Spacing.spacing20,
                vertical = Spacing.spacing6
            )
    ) {
        Text(
            text = label,
            color = textColor,
            style = typography.bodyMedium
        )
    }
}

@Composable
@Preview
private fun FilterChipItemPreview() {
    FoodGoTheme {
        FilterChipItem("Pizza", false) { }
    }
}