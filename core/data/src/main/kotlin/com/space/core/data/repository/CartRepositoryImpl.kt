package com.space.core.data.repository

import com.space.core.data.local.dao.CartDao
import com.space.core.data.mapper.CartEntityMapper
import com.space.core.data.mapper.CartItemMapper
import com.space.core.domain.model.CartItem
import com.space.core.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartRepositoryImpl(
    private val cartDao: CartDao,
    private val cartItemMapper: CartItemMapper,
    private val cartEntityMapper: CartEntityMapper
) : CartRepository {

    override fun getCartItems(): Flow<List<CartItem>> {
        return cartDao.getAllCartItems().map { entities ->
            entities.map { cartEntityMapper.map(it) }
        }
    }

    override fun getCartItemsCount(): Flow<Int> {
        return cartDao.getCartItemsCount()
    }

    override suspend fun addToCart(item: CartItem) {
        val existingItem = cartDao.getCartItemById(item.id)

        if (existingItem != null) {
            cartDao.increment(item.id)
        } else {
            cartDao.insertCartItem(cartItemMapper.map(item))
        }
    }

    override suspend fun incrementItem(productId: Int) {
        cartDao.increment(productId)
    }

    override suspend fun decrementItem(productId: Int) {
        val existingItem = cartDao.getCartItemById(productId) ?: return

        if (existingItem.quantity <= 1) {
            cartDao.deleteCartItemById(productId)
        } else {
            cartDao.decrement(productId)
        }
    }

    override suspend fun removeItemById(productId: Int) {
        cartDao.deleteCartItemById(productId)
    }

    override suspend fun clearCart() {
        cartDao.clearCart()
    }
}