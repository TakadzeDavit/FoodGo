package com.space.foodgo.feature.menu.presentation.contract

import com.space.core.presentation.common.UiEvent
import com.space.foodgo.feature.menu.presentation.component.filter.FoodFilter
import com.space.foodgo.feature.menu.presentation.model.CartItemUi

sealed class MenuEvent : UiEvent {
    data class OnFilterSelected(val filter: FoodFilter) : MenuEvent()
    data class OnAddToCart(val item: CartItemUi) : MenuEvent()
    data class OnIncrementQuantity(val productId: Int, val newQuantity: Int) : MenuEvent()
    data object OnCartClick : MenuEvent()
}