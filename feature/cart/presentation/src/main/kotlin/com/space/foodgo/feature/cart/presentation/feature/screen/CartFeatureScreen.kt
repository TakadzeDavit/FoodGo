package com.space.foodgo.feature.cart.presentation.feature.screen

import androidx.compose.runtime.Composable
import com.space.core.presentation.common.FlowContainer
import com.space.foodgo.feature.cart.presentation.navigator.CartScreenKey
import com.space.foodgo.feature.cart.presentation.navigator.cartFlowEntry

@Composable
fun CartFeatureScreen() {
    FlowContainer(
        initialKey = CartScreenKey,
        entry = {
            cartFlowEntry()
        }
    )
}