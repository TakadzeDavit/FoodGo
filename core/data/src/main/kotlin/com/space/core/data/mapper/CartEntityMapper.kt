package com.space.core.data.mapper

import com.space.core.data.local.entity.CartEntity
import com.space.core.domain.common.BaseMapper
import com.space.core.domain.model.CartItem

class CartEntityMapper : BaseMapper<CartEntity, CartItem> {
    override fun map(input: CartEntity): CartItem {
        return CartItem(
            id = input.id,
            name = input.name,
            price = input.price,
            imageResId = input.imageResId,
            quantity = input.quantity
        )
    }
}