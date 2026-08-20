package com.space.foodgo.feature.cart.presentation.di

import com.space.foodgo.feature.cart.presentation.flow.cart.mapper.ToCartProductUiMapper
import com.space.foodgo.feature.cart.presentation.flow.cart.mapper.ToDomainCartItemMapper
import com.space.foodgo.feature.cart.presentation.flow.cart.vm.CartVm
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureCartPresentation = module {
    viewModelOf(::CartVm)
    factoryOf(::ToCartProductUiMapper)
    factoryOf(::ToDomainCartItemMapper)
}