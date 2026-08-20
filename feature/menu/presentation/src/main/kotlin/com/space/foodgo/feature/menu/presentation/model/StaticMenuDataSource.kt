package com.space.foodgo.feature.menu.presentation.model

import com.space.foodgo.feature.menu.presentation.R
import com.space.foodgo.feature.menu.presentation.component.filter.FoodFilter

object StaticMenuDataSource {
    fun getMenuItems(): List<CartItemUi> = listOf(
        CartItemUi(
            id = 1,
            name = "Margherita",
            description = "Classic tomato & mozzarella",
            price = 14.50,
            imageResId = R.mipmap.food_img_foreground,
            type = FoodFilter.PIZZA
        ),
        CartItemUi(
            id = 2,
            name = "Pepperoni",
            description = "Spicy pepperoni with cheese",
            price = 17.00,
            imageResId = R.mipmap.food_img_foreground,
            type = FoodFilter.PIZZA
        ),
        CartItemUi(
            id = 3,
            name = "Caesar Salad",
            description = "Romaine, croutons, parmesan",
            price = 10.00,
            imageResId = R.mipmap.food_img_foreground,
            type = FoodFilter.SALADS
        ),
        CartItemUi(
            id = 4,
            name = "Coca Cola",
            description = "330ml can",
            price = 3.00,
            imageResId = R.mipmap.food_img_foreground,
            type = FoodFilter.DRINKS
        )
    )
}