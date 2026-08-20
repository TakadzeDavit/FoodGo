package com.space.foodgo.feature.cart.presentation.flow.order.contract

import com.space.core.presentation.common.UiEvent

sealed interface OrderTimerEvent : UiEvent {
    data object OnFinishOrderClick : OrderTimerEvent
}