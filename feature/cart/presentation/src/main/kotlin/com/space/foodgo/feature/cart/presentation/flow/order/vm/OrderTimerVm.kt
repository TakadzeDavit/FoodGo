package com.space.foodgo.feature.cart.presentation.flow.order.vm

import androidx.lifecycle.viewModelScope
import com.space.core.domain.usecase.ClearCartUseCase
import com.space.core.presentation.common.BaseVm
import com.space.foodgo.feature.cart.presentation.flow.order.contract.OrderTimerEvent
import com.space.foodgo.feature.cart.presentation.flow.order.contract.OrderTimerState
import com.space.foodgo.feature.cart.presentation.flow.order.contract.OrderTimerState.Companion.TOTAL_SECONDS
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class OrderTimerVm(
    private val clearCartUseCase: ClearCartUseCase
) : BaseVm<OrderTimerState, OrderTimerEvent>(OrderTimerState()) {

    init {
        startCountDown()
    }

    override fun onEvent(event: OrderTimerEvent) {
        when (event) {
            is OrderTimerEvent.OnFinishOrderClick -> finishOrder()
        }
    }

    private fun finishOrder() {
        viewModelScope.launch {
            clearCartUseCase()
            globalNavigator { pop() }
        }
    }

    private fun startCountDown() {
        viewModelScope.launch {
            for (remaining in TOTAL_SECONDS downTo 0) {
                updateState { copy(secondsRemaining = remaining) }
                if (remaining > 0) delay(1000.milliseconds)
            }
        }
    }
}