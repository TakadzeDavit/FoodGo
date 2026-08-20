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
        targetValue = if (isSelected) Color.White else colors.textSecondary
    )
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) colors.primary else Color.White
    )
    val borderColor = if (isSelected) Color.Transparent else colors.textSecondary

    Box(
        modifier = Modifier
            .clip(Radius.Radius50)
            .background(backgroundColor)
            .border(Sizing.size1, borderColor, Radius.Radius50)
            .clickable(onClick = onClick)
            .padding(horizontal = Spacing.spacing20, vertical = Spacing.spacing10)
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = TextSizing.size14,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
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