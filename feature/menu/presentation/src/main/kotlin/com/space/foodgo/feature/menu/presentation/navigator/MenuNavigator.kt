package com.space.foodgo.feature.menu.presentation.navigator

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.space.foodgo.feature.menu.api.MenuFeatureKey
import com.space.foodgo.feature.menu.presentation.screen.MenuScreen

fun EntryProviderScope<NavKey>.menuEntry() {
    entry<MenuFeatureKey> {
        MenuScreen()
    }
}