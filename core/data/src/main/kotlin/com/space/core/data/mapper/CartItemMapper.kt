package com.space.core.data.mapper

import com.space.core.data.local.entity.CartEntity
import com.space.core.domain.common.BaseMapper
import com.space.core.domain.model.CartItem

class CartItemMapper : BaseMapper<CartItem, CartEntity> {
    override fun map(input: CartItem): CartEntity {
        return CartEntity(
            id = input.id,
            name = input.name,
            price = input.price,
            imageResId = input.imageResId,
            quantity = input.quantity
        )
    }
}