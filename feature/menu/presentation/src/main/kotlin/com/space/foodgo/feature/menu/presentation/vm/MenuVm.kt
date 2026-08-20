package com.space.foodgo.feature.menu.presentation.vm

import com.space.core.presentation.common.BaseVm
import com.space.foodgo.feature.menu.presentation.contract.MenuEvent
import com.space.foodgo.feature.menu.presentation.contract.MenuState
import androidx.lifecycle.viewModelScope
import com.space.core.domain.usecase.AddToCartUseCase
import com.space.core.domain.usecase.GetCartItemsUseCase
import com.space.core.domain.usecase.IncrementCartItemUseCase
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
            is MenuEvent.OnFilterSelected -> {
                updateState { copy(selectedFilter = event.filter) }
                applyFilter(event.filter)
            }
            is MenuEvent.OnAddToCart -> {
                viewModelScope.launch {
                    val domainItem = cartItemUiMapper.map(event.item)
                    addToCartUseCase(domainItem)
                }
            }
            is MenuEvent.OnIncrementQuantity -> {
                viewModelScope.launch {
                    incrementCartItemUseCase(event.productId)
                }
            }
            is MenuEvent.OnCartClick -> {
                // ნავიგაცია კალათის სქრინზე (გაგზავნე SideEffect ან გამოიყენე შენი Navigator)
            }
        }
    }

    private fun observeCartData() {
        getCartItemsUseCase()
            .onEach { cartItems ->
                val quantitiesMap = cartItems.associate { it.id to it.quantity }
                val totalCount = cartItems.sumOf { it.quantity }

                updateState {
                    copy(
                        cartItemsCount = totalCount,
                        cartItemQuantities = quantitiesMap
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    private fun applyFilter(filter: FoodFilter) {
        val filteredList = if (filter == FoodFilter.ALL) {
            allProducts
        } else {
            allProducts.filter { it.type.name.equals(filter.name, ignoreCase = true) }
        }
        updateState { copy(menuItems = filteredList) }
    }
}