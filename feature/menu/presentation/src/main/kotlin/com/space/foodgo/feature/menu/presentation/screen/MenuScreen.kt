package com.space.foodgo.feature.menu.presentation.screen

import androidx.compose.runtime.Composable
import com.space.core.presentation.common.BaseScreen
import com.space.foodgo.feature.menu.presentation.contract.MenuEvent
import com.space.foodgo.feature.menu.presentation.contract.MenuState
import com.space.foodgo.feature.menu.presentation.vm.MenuVm
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.Radius
import com.space.core.ui.theme.Spacing
import com.space.foodgo.feature.menu.presentation.component.card.MenuItemCard
import com.space.foodgo.feature.menu.presentation.component.filter.FoodFilterRow
import com.space.core.ui.R

@Composable
fun MenuScreen() {
    BaseScreen(
        vmClass = MenuVm::class,
        content = { state, onEvent ->
            MenuScreenContent(
                state = state,
                onEvent = onEvent
            )
        }
    )
}

@Composable
private fun MenuScreenContent(
    state: MenuState,
    onEvent: (MenuEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        Spacer(modifier = Modifier.height(Spacing.spacing16))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Spacing.spacing16),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "FoodGo",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = colors.textPrimary
                )
                Text(
                    text = "What would you like to eat?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.textSecondary
                )
            }

            // Cart Button with Badge
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(Radius.radius12)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .clickable { onEvent(MenuEvent.OnCartClick) },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Cart",
                    tint = colors.textPrimary,
                    modifier = Modifier.size(24.dp)
                )

                if (state.cartItemsCount > 0) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(x = 4.dp, y = (-4).dp)
                            .size(20.dp)
                            .background(colors.primary, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${state.cartItemsCount}",
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(Spacing.spacing20))

        // Filter Categories
        FoodFilterRow(
            selected = state.selectedFilter,
            modifier = Modifier.fillMaxWidth(),
            onFilterSelected = { filter ->
                onEvent(MenuEvent.OnFilterSelected(filter))
            }
        )

        Spacer(modifier = Modifier.height(Spacing.spacing16))

        // Product Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                horizontal = Spacing.spacing16,
                vertical = Spacing.spacing8
            ),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacing12),
            verticalArrangement = Arrangement.spacedBy(Spacing.spacing12),
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                items = state.menuItems,
                key = { it.id }
            ) { item ->
                // იღებს ამ ნივთის რაოდენობას კალათიდან (თუ არ არის, აბრუნებს 0-ს)
                val cartQuantity = state.cartItemQuantities[item.id] ?: 0

                MenuItemCard(
                    item = item,
                    cartQuantity = cartQuantity,
                    onAddToCart = { selectedItem ->
                        onEvent(MenuEvent.OnAddToCart(selectedItem))
                    },
                    onIncrementQuantity = { productId, newQuantity ->
                        onEvent(MenuEvent.OnIncrementQuantity(productId, newQuantity))
                    }
                )
            }
        }
    }
}