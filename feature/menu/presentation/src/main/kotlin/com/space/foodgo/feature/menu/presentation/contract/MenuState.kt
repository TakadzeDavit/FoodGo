package com.space.foodgo.feature.menu.presentation.contract

import com.space.core.presentation.common.UiState
import com.space.foodgo.feature.menu.presentation.model.FoodFilter
import com.space.foodgo.feature.menu.presentation.model.CartItemUi

data class MenuState(
    val loading: Boolean = false,
    val selectedFilter: FoodFilter = FoodFilter.ALL,
    val menuItems: List<CartItemUi> = emptyList(),
    val cartItemsCount: Int = 0,
    val cartItemQuantities: Map<Int, Int> = emptyMap()
) : UiState