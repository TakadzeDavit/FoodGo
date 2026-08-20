package com.space.foodgo.feature.cart.presentation.navigator

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.space.foodgo.feature.cart.api.CartFeatureKey
import com.space.foodgo.feature.cart.presentation.feature.screen.CartFeatureScreen
import com.space.foodgo.feature.cart.presentation.flow.cart.screen.CartScreen
import com.space.foodgo.feature.cart.presentation.flow.order.screen.OrderTimerScreen

fun EntryProviderScope<NavKey>.cartEntry() {
    entry<CartFeatureKey> {
        CartFeatureScreen()
    }
}

internal fun EntryProviderScope<NavKey>.cartFlowEntry() {
    entry<CartScreenKey> {
        CartScreen()
    }

    entry<OrderScreenKey> {
        OrderTimerScreen()
    }
}