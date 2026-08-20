package com.space.foodgo.feature.menu.presentation.mapper

import com.space.core.domain.common.BaseMapper
import com.space.core.domain.model.CartItem
import com.space.foodgo.feature.menu.presentation.model.CartItemUi

class CartItemMapper : BaseMapper<CartItemUi, CartItem> {
    override fun map(input: CartItemUi): CartItem {
        return CartItem(
            id = input.id,
            name = input.name,
            price = input.price,
            imageResId = input.imageResId
        )
    }
}