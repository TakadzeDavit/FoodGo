package com.space.core.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.scene.SinglePaneSceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.space.core.navigation.FlowNavigationKey
import com.space.core.navigation.LocalFlowNavigator
import com.space.core.navigation.featurePopTransitionSpec
import com.space.core.navigation.featurePredictivePopTransitionSpec
import com.space.core.navigation.featureTransitionSpec
import com.space.core.navigation.rememberNavigator
import com.space.core.navigation.requireGlobalNavigator


@Composable
fun FlowContainer(
    initialKey: FlowNavigationKey,
    entry: EntryProviderScope<NavKey>.() -> Unit
) {
    val globalNavigator = requireGlobalNavigator()
    val navigator = rememberNavigator(initialKey)

    CompositionLocalProvider(LocalFlowNavigator provides navigator) {
        NavDisplay(
            backStack = navigator.backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            sceneStrategies = listOf(
                remember { SinglePaneSceneStrategy() }
            ),
            onBack =
                { if (navigator.backStack.size > 1) navigator.pop() else globalNavigator.pop() },
            transitionSpec = featureTransitionSpec(),
            popTransitionSpec = featurePopTransitionSpec(),
            predictivePopTransitionSpec = featurePredictivePopTransitionSpec(),
            entryProvider = entryProvider {
                entry.invoke(this)
            }
        )
    }
}