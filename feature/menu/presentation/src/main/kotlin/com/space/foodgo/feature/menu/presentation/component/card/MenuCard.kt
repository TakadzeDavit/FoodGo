package com.space.foodgo.feature.menu.presentation.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Radius
import com.space.core.ui.theme.Sizing
import com.space.core.ui.theme.Spacing
import com.space.core.ui.theme.TextSizing
import com.space.foodgo.feature.menu.presentation.model.CartItemUi

@Composable
fun MenuItemCard(
    item: CartItemUi,
    cartQuantity: Int,
    onAddToCart: (CartItemUi) -> Unit,
    onIncrementQuantity: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = Radius.radius16,
        colors = CardDefaults.cardColors(
            containerColor = colors.cardBg
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Spacing.spacing12)
            ) {
                Text(
                    text = item.name,
                    style = typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colors.textPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(Spacing.spacing6))

                Text(
                    text = item.description,
                    style = typography.labelSmall,
                    color = colors.textSecondary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(Spacing.spacing8))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "₾ ${"%.2f".format(item.price)}",
                        style = typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = colors.textPrimary
                    )

                    if (cartQuantity == 0) {
                        Box(
                            modifier = Modifier
                                .clip(Radius.radius8)
                                .background(colors.addedBg)
                                .clickable { onAddToCart(item) }
                                .padding(
                                    horizontal = Spacing.spacing10,
                                    vertical = Spacing.spacing4
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Add",
                                color = colors.onPrimary,
                                fontSize = TextSizing.size12,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .clip(Radius.radius8)
                                .background(Color.Transparent)
                                .clickable { onIncrementQuantity(item.id, cartQuantity + 1) }
                                .padding(
                                    horizontal = Spacing.spacing10,
                                    vertical = Spacing.spacing6
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Added ✓",
                                color = colors.addedText,
                                fontSize = TextSizing.size12,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
