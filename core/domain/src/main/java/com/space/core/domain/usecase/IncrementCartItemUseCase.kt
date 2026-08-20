package com.space.core.domain.usecase

import com.space.core.domain.repository.CartRepository

class IncrementCartItemUseCase(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(productId: Int) {
        cartRepository.incrementItem(productId)
    }
}