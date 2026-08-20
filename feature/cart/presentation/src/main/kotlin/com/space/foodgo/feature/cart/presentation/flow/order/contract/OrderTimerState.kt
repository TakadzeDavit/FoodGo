package com.space.foodgo.feature.cart.presentation.flow.order.contract

import com.space.core.presentation.common.UiState

data class OrderTimerState(
    val secondsRemaining: Int = TOTAL_SECONDS
) : UiState {
    val progress: Float get() = secondsRemaining / TOTAL_SECONDS.toFloat()
    val timeLabel: String get() = "0:${secondsRemaining.toString().padStart(2, '0')}"
    val isFinished: Boolean get() = secondsRemaining == 0

    companion object {
        const val TOTAL_SECONDS = 15
    }
}