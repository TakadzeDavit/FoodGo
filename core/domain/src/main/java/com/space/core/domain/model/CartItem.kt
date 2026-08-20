package com.space.core.domain.model

data class CartItem(
    val id: Int,
    val name: String,
    val price: Double,
    val imageResId: Int,
    val quantity: Int = 1
)