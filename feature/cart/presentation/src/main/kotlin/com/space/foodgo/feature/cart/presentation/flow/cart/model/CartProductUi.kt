package com.space.foodgo.feature.cart.presentation.flow.cart.model

data class CartProductUi (
    val id: Int,
    val name: String,
    val price: Double,
    val imageResId: Int,
    val quantity: Int = 1
)