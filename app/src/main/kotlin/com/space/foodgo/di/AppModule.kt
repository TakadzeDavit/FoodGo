package com.space.foodgo.di

import com.space.core.data.di.coreDataModule
import com.space.core.presentation.di.corePresentationModule
import com.space.foodgo.feature.menu.presentation.di.menuPresentationModule
import org.koin.dsl.module

val appModule = module {
    includes(
        corePresentationModule,
        coreDataModule,
        menuPresentationModule
    )
}