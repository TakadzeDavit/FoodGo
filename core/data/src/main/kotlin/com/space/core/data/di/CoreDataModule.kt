package com.space.core.data.di

import androidx.room.Room
import com.space.core.data.local.database.FoodGoDatabase
import com.space.core.data.mapper.CartEntityMapper
import com.space.core.data.mapper.CartItemMapper
import com.space.core.data.repository.CartRepositoryImpl
import com.space.core.domain.repository.CartRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val coreDataModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            FoodGoDatabase::class.java,
            "foodgo_cart.db"
        ).fallbackToDestructiveMigration(false).build()
    }

    single { get<FoodGoDatabase>().cartDao }

    single<CartRepositoryImpl>() bind CartRepository::class

    factoryOf(::CartItemMapper)
    factoryOf(::CartEntityMapper)
}