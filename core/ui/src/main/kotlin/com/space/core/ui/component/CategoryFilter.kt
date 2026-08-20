package com.space.core.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.space.ui.theme.FoodGoAppTheme.colors
import com.space.ui.theme.Radius
import com.space.ui.theme.Sizing
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.space.ui.theme.FoodGoAppTheme
import com.space.ui.theme.Spacing
import com.space.ui.theme.TextSizing

enum class FoodFilter(val label: String) {
    ALL("All"),
    PIZZA("Pizza"),
    SALADS("Salads"),
    DRINKS("Drinks")
}

@Composable
fun FoodFilterRow(
    selected: FoodFilter,
    modifier: Modifier,
    onFilterSelected: (FoodFilter) -> Unit
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = Spacing.spacing16),
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacing8)
    ) {
        items(FoodFilter.entries) { filter ->
            FilterChipItem(
                label = filter.label,
                isSelected = filter == selected,
                onClick = { onFilterSelected(filter) }
            )
        }
    }
}

@Composable
private fun FilterChipItem(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) colors.white else colors.textSecondary
    )
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) colors.primaryBlue else colors.white
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
    FoodGoAppTheme {
        FilterChipItem("Pizza", false) { }
    }
}

@Composable
@Preview
private fun FilterChipRowPreview() {
    FoodGoAppTheme {
        FoodFilterRow(
            selected = FoodFilter.ALL,
            modifier = Modifier
        ) { }
    }
}