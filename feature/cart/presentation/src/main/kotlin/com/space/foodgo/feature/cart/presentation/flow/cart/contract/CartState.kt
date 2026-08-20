package com.space.foodgo.feature.cart.presentation.flow.cart.contract

import com.space.core.presentation.common.UiState
import com.space.foodgo.feature.cart.presentation.flow.cart.model.CartProductUi

data class CartState(
    val cartItems: List<CartProductUi> = emptyList(),
    val totalPrice: Double = 0.0,
    val isLoading: Boolean = false
) : UiState