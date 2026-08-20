package com.space.foodgo.feature.cart.presentation.flow.cart.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.space.core.presentation.common.BaseScreen
import com.space.core.ui.component.EmptyCartComponent
import com.space.core.ui.component.FoodGoPrimaryButton
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Radius
import com.space.core.ui.theme.Sizing
import com.space.core.ui.theme.Spacing
import com.space.foodgo.feature.cart.presentation.R
import com.space.foodgo.feature.cart.presentation.flow.cart.component.CartItemCard
import com.space.foodgo.feature.cart.presentation.flow.cart.component.CartTopBar
import com.space.foodgo.feature.cart.presentation.flow.cart.component.TotalSummaryCard
import com.space.foodgo.feature.cart.presentation.flow.cart.contract.CartEvent
import com.space.foodgo.feature.cart.presentation.flow.cart.contract.CartState
import com.space.foodgo.feature.cart.presentation.flow.cart.vm.CartVm

@Composable
fun CartScreen() {
    BaseScreen(
        vmClass = CartVm::class,
        content = { state, onEvent ->
            CartScreenContent(
                state = state,
                onEvent = onEvent
            )
        }
    )
}

@Composable
private fun CartScreenContent(
    state: CartState,
    onEvent: (CartEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(horizontal = Spacing.spacing16)
    ) {
        Spacer(modifier = Modifier.height(Spacing.spacing16))

        CartTopBar(
            title = stringResource(R.string.my_cart),
            onBackClick = { onEvent(CartEvent.OnBackClick) }
        )

        Spacer(modifier = Modifier.height(Spacing.spacing12))

        if (state.cartItems.isEmpty()) {
            EmptyCartComponent(
                onBrowseMenuClick = { onEvent(CartEvent.OnBrowseMenuClick) }
            )
        } else {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(Spacing.spacing12)
                ) {
                    items(
                        items = state.cartItems,
                        key = { it.id }
                    ) { cartItem ->
                        CartItemCard(
                            item = cartItem,
                            quantity = cartItem.quantity,
                            onIncrement = { id -> onEvent(CartEvent.OnIncrementQuantity(id)) },
                            onDecrement = { id -> onEvent(CartEvent.OnDecrementQuantity(id)) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(Spacing.spacing16))

                TotalSummaryCard(
                    totalPrice = state.totalPrice
                )

                Spacer(modifier = Modifier.height(Spacing.spacing16))

                FoodGoPrimaryButton(
                    text = stringResource(R.string.place_order),
                    onClick = { onEvent(CartEvent.OnPlaceOrderClick) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Sizing.size52)
                )

                Spacer(modifier = Modifier.height(Spacing.spacing22))
            }
        }
    }
}