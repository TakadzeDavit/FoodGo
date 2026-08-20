package com.space.foodgo

import android.app.Application
import com.space.foodgo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class FoodGo : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FoodGo)
            modules (appModule)
        }
    }
}