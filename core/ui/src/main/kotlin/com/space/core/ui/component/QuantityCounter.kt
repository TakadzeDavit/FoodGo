package com.space.core.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.space.core.ui.R
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Radius
import com.space.core.ui.theme.Sizing

@Composable
fun QuantityCounter(
    quantity: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(Sizing.size36)
            .background(
                color = colors.cardBg,
                shape = Radius.radius8
            )
            .border(
                width = Sizing.size1,
                color = colors.textSecondary,
                shape = Radius.radius8
            )
            .clip(Radius.radius8),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(Sizing.size36)
                .clickable(onClick = onMinusClick),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(
                    id = if (quantity == 1) R.drawable.ic_close else R.drawable.ic_remove
                ),
                contentDescription = if (quantity == 1) "Delete" else "Remove"
            )
        }

        Box(
            modifier = Modifier.size(Sizing.size36),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quantity.toString(),
                style = typography.titleMedium,
                color = colors.textPrimary
            )
        }

        Box(
            modifier = Modifier
                .size(Sizing.size36)
                .clickable(onClick = onPlusClick),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = "Add"
            )
        }
    }
}