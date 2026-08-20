package com.space.foodgo.feature.menu.presentation.vm

import com.space.core.presentation.common.BaseVm
import com.space.foodgo.feature.menu.presentation.contract.MenuEvent
import com.space.foodgo.feature.menu.presentation.contract.MenuState
import androidx.lifecycle.viewModelScope
import com.space.core.domain.usecase.AddToCartUseCase
import com.space.core.domain.usecase.GetCartItemsUseCase
import com.space.core.domain.usecase.IncrementCartItemUseCase
import com.space.foodgo.feature.cart.api.CartFeatureKey
import com.space.foodgo.feature.menu.presentation.component.filter.FoodFilter
import com.space.foodgo.feature.menu.presentation.mapper.CartItemMapper
import com.space.foodgo.feature.menu.presentation.model.CartItemUi
import com.space.foodgo.feature.menu.presentation.model.StaticMenuDataSource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MenuVm(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val addToCartUseCase: AddToCartUseCase,
    private val incrementCartItemUseCase: IncrementCartItemUseCase,
    private val cartItemUiMapper: CartItemMapper
) : BaseVm<MenuState, MenuEvent>(MenuState()) {

    private val allProducts: List<CartItemUi> = StaticMenuDataSource.getMenuItems()

    init {
        observeCartData()
        applyFilter(FoodFilter.ALL)
    }

    override fun onEvent(event: MenuEvent) {
        when (event) {
            is MenuEvent.OnFilterSelected -> applyFilter(event.filter)
            is MenuEvent.OnAddToCart -> addToCart(event.item)
            is MenuEvent.OnIncrementQuantity -> incrementQuantity(event.productId)
            is MenuEvent.OnCartClick -> {
                globalNavigator { push(CartFeatureKey) }
            }
        }
    }

    private fun incrementQuantity(productId: Int) {
        viewModelScope.launch {
            incrementCartItemUseCase(productId)
        }
    }

    private fun addToCart(item: CartItemUi) {
        viewModelScope.launch {
            val domainItem = cartItemUiMapper.map(item)
            addToCartUseCase(domainItem)
        }
    }

    private fun observeCartData() {
        viewModelScope.launch {
            getCartItemsUseCase().collect { cartItems ->
                val quantitiesMap = cartItems.associate { it.id to it.quantity }
                val totalCount = cartItems.sumOf { it.quantity }

                updateState {
                    copy(
                        cartItemsCount = totalCount,
                        cartItemQuantities = quantitiesMap
                    )
                }
            }
        }
    }

    private fun applyFilter(filter: FoodFilter) {
        updateState { copy(selectedFilter = filter) }

        val filteredList = if (filter == FoodFilter.ALL) {
            allProducts
        } else {
            allProducts.filter { it.type.name.equals(filter.name, ignoreCase = true) }
        }
        updateState { copy(menuItems = filteredList) }
    }
}