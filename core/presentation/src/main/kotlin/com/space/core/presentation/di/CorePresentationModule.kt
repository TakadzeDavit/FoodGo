package com.space.core.presentation.di

import com.space.core.domain.usecase.AddToCartUseCase
import com.space.core.domain.usecase.ClearCartUseCase
import com.space.core.domain.usecase.DecrementCartItemUseCase
import com.space.core.domain.usecase.GetCartItemsUseCase
import com.space.core.domain.usecase.GetCartTotalPriceUseCase
import com.space.core.domain.usecase.IncrementCartItemUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val corePresentationModule = module {
    factoryOf(::AddToCartUseCase)
    factoryOf(::ClearCartUseCase)
    factoryOf(::DecrementCartItemUseCase)
    factoryOf(::GetCartItemsUseCase)
    factoryOf(::GetCartTotalPriceUseCase)
    factoryOf(::IncrementCartItemUseCase)
}