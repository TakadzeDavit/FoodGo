package com.space.core.domain.usecase

import com.space.core.domain.repository.CartRepository

class DecrementCartItemUseCase(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(productId: Int) {
        cartRepository.decrementItem(productId)
    }
}