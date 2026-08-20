package com.space.foodgo.feature.cart.presentation.navigator

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.space.foodgo.feature.cart.api.CartFeatureKey
import com.space.foodgo.feature.cart.presentation.feature.screen.CartFeatureScreen

fun EntryProviderScope<NavKey>.cartEntry() {
    entry<CartFeatureKey> {
        CartFeatureScreen()
    }
}

internal fun EntryProviderScope<NavKey>.cartFlowEntry() {
    entry<CartScreenKey> {

    }

    entry<OrderScreenKey> {  }
}