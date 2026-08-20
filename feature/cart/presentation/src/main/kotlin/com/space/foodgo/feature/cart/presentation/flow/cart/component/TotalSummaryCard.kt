package com.space.foodgo.feature.cart.presentation.flow.cart.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Radius
import com.space.core.ui.theme.Spacing

@Composable
fun TotalSummaryCard(
    totalPrice: Double,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(Radius.radius12)
            .background(colors.cardBg)
            .padding(horizontal = Spacing.spacing16, vertical = Spacing.spacing16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Total",
            style = typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = colors.textPrimary
        )

        Text(
            text = "₾ ${"%.2f".format(totalPrice)}",
            style = typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = colors.textPrimary
        )
    }
}