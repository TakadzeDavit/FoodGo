package com.space.core.domain.usecase

import com.space.core.domain.model.CartItem
import com.space.core.domain.repository.CartRepository

class AddToCartUseCase(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(item: CartItem) {
        cartRepository.addToCart(item)
    }
}