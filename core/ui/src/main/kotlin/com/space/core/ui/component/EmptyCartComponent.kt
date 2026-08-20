package com.space.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Spacing

@Composable
fun EmptyCartComponent(
    onBrowseMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .dashedBorder(
                color = colors.textSecondary.copy(alpha = 0.4f),
                strokeWidth = 1.5.dp,
                cornerRadius = 20.dp,
                dashLength = 6.dp,
                gapLength = 4.dp
            )
            .padding(vertical = Spacing.spacing22, horizontal = Spacing.spacing16),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(color = colors.surface, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "cart",
                color = colors.textSecondary,
                style = typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(Spacing.spacing20))

        Text(
            text = "Your cart is empty",
            style = typography.titleLarge,
            color = colors.textPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Spacing.spacing6))

        Text(
            text = "Add items from the menu",
            style = typography.bodyMedium,
            color = colors.textSecondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Spacing.spacing36))

        FoodGoPrimaryButton(
            text = "Browse menu",
            onClick = onBrowseMenuClick,
            modifier = Modifier.fillMaxWidth(0.85f)
        )
    }
}