package com.space.foodgo.feature.menu.presentation.model

data class CartItemUi(
    val id: Int,
    val name: String,
    val price: Double,
    val imageResId: Int,
    val description: String,
    val type: FoodFilter,
    val quantity: Int = 1
)