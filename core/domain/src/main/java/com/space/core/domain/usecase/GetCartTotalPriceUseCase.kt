package com.space.core.domain.usecase

import com.space.core.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCartTotalPriceUseCase(
    private val cartRepository: CartRepository
) {
    operator fun invoke(): Flow<Double> {
        return cartRepository.getCartItems().map { items ->
            items.sumOf { it.price * it.quantity }
        }
    }
}