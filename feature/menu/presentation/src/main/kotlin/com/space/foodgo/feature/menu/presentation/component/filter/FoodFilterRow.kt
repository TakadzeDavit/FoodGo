package com.space.foodgo.feature.menu.presentation.component.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.space.core.ui.theme.FoodGoTheme
import com.space.core.ui.theme.Spacing
import com.space.foodgo.feature.menu.presentation.model.FoodFilter

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
@Preview
private fun FilterChipRowPreview() {
    FoodGoTheme {
        FoodFilterRow(
            selected = FoodFilter.ALL,
            modifier = Modifier
        ) { }
    }
}