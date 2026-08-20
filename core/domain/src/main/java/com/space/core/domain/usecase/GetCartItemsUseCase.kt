package com.space.core.domain.usecase

import com.space.core.domain.model.CartItem
import com.space.core.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class GetCartItemsUseCase(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<List<CartItem>> {
        return cartRepository.getCartItems()
    }
}