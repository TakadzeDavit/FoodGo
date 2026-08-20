package com.space.core.domain.usecase

import com.space.core.domain.repository.CartRepository

class ClearCartUseCase(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke() {
        cartRepository.clearCart()
    }
}