package com.space.foodgo.feature.menu.presentation.di

import com.space.foodgo.feature.menu.presentation.mapper.CartItemMapper
import com.space.foodgo.feature.menu.presentation.vm.MenuVm
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val menuPresentationModule = module {
    viewModelOf(::MenuVm)
    factoryOf(::CartItemMapper)


}