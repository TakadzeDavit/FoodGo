package com.space.core.domain.repository

import com.space.core.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartItems(): Flow<List<CartItem>>
    fun getCartItemsCount(): Flow<Int>
    suspend fun addToCart(item: CartItem)
    suspend fun incrementItem(productId: Int)
    suspend fun decrementItem(productId: Int)
    suspend fun removeItemById(productId: Int)
    suspend fun clearCart()
}