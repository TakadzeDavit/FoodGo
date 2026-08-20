package com.space.foodgo.feature.cart.presentation.flow.cart.mapper

import com.space.core.domain.common.BaseMapper
import com.space.core.domain.model.CartItem
import com.space.foodgo.feature.cart.presentation.flow.cart.model.CartProductUi

class ToCartProductUiMapper : BaseMapper<CartItem, CartProductUi>{
    override fun map(input: CartItem): CartProductUi {
        return CartProductUi(
            id = input.id,
            name = input.name,
            price = input.price,
            imageResId = input.imageResId,
            quantity = input.quantity
        )
    }
}