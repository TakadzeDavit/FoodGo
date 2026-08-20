package com.space.foodgo.feature.cart.presentation.flow.cart.vm

import androidx.lifecycle.viewModelScope
import com.space.core.domain.usecase.DecrementCartItemUseCase
import com.space.core.domain.usecase.GetCartItemsUseCase
import com.space.core.domain.usecase.IncrementCartItemUseCase
import com.space.core.presentation.common.BaseVm
import com.space.foodgo.feature.cart.presentation.flow.cart.contract.CartEvent
import com.space.foodgo.feature.cart.presentation.flow.cart.contract.CartState
import com.space.foodgo.feature.cart.presentation.flow.cart.mapper.ToCartProductUiMapper
import com.space.foodgo.feature.cart.presentation.navigator.OrderScreenKey
import kotlinx.coroutines.launch

class CartVm(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val toCartProductUiMapper: ToCartProductUiMapper,
    private val incrementCartItemUseCase: IncrementCartItemUseCase,
    private val decrementCartItemUseCase: DecrementCartItemUseCase
) : BaseVm<CartState, CartEvent>(CartState()) {

    init {
        observeCart()
    }

    override fun onEvent(event: CartEvent) {
        when (event) {
            is CartEvent.OnBackClick -> {
                globalNavigator { pop() }
            }
            is CartEvent.OnBrowseMenuClick -> {
                globalNavigator { pop() }
            }
            is CartEvent.OnPlaceOrderClick -> handlePlaceOrder()
            is CartEvent.OnIncrementQuantity -> incrementQuantity(event.itemId)
            is CartEvent.OnDecrementQuantity -> decrementQuantity(event.itemId)
        }
    }

    private fun observeCart() {
        viewModelScope.launch {
            getCartItemsUseCase().collect { items ->
                val total = items.sumOf { it.price * it.quantity }
                val mappedList = items.map(toCartProductUiMapper::map)

                updateState {
                    copy(
                        cartItems = mappedList,
                        totalPrice = total
                    )
                }
            }
        }
    }

    private fun incrementQuantity(itemId: Int) {
        viewModelScope.launch {
            incrementCartItemUseCase(itemId)
        }
    }

    private fun decrementQuantity(itemId: Int) {
        viewModelScope.launch {
            decrementCartItemUseCase(itemId)
        }
    }

    private fun handlePlaceOrder() {
        flowNavigator { push(OrderScreenKey) }
    }
}