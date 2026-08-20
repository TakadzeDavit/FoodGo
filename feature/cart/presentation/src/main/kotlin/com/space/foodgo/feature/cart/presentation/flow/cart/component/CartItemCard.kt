package com.space.foodgo.feature.cart.presentation.flow.cart.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.space.core.ui.component.QuantityCounter
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Radius
import com.space.core.ui.theme.Spacing
import com.space.foodgo.feature.cart.presentation.flow.cart.model.CartProductUi

@Composable
fun CartItemCard(
    item: CartProductUi,
    quantity: Int,
    onIncrement: (Int) -> Unit,
    onDecrement: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacing8),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(Radius.radius16)
            )

            Spacer(modifier = Modifier.width(Spacing.spacing12))

            Column {
                Text(
                    text = item.name,
                    style = typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colors.textPrimary
                )

                Spacer(modifier = Modifier.height(Spacing.spacing4))

                Text(
                    text = "₾ ${"%.2f".format(item.price)}",
                    style = typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.textPrimary
                )
            }
        }

        QuantityCounter(
            quantity = quantity,
            onPlusClick = { onIncrement(item.id) },
            onMinusClick = { onDecrement(item.id) }
        )
    }
}