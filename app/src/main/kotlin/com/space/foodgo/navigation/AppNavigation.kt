package com.space.foodgo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.space.core.navigation.LocalGlobalNavigator
import com.space.core.navigation.rememberNavigator
import com.space.foodgo.MainActivity
import com.space.foodgo.feature.menu.api.MenuFeatureKey

@Composable
fun MainActivity.FoodGoContainer() {
    val navigator = rememberNavigator(MenuFeatureKey)

    CompositionLocalProvider(
        LocalGlobalNavigator provides navigator
    ) {
        NavDisplay(
            backStack = navigator.backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            onBack = {
                if (navigator.backStack.size > 1) navigator.pop() else finishAffinity()
            },
            entryProvider = entryProvider {
            },
        )
    }
}