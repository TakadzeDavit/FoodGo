package com.space.foodgo.feature.cart.presentation.flow.cart.contract

import com.space.core.presentation.common.UiEvent

sealed interface CartEvent : UiEvent {
    data object OnBackClick : CartEvent
    data object OnBrowseMenuClick : CartEvent
    data object OnPlaceOrderClick : CartEvent
    data class OnIncrementQuantity(val itemId: Int) : CartEvent
    data class OnDecrementQuantity(val itemId: Int) : CartEvent
}