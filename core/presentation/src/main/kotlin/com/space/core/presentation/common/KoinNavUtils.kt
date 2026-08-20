package com.space.core.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.space.core.navigation.NavCommandBundle
import com.space.core.navigation.globalNavigator
import com.space.core.navigation.localNavigator
import com.space.core.navigation.requireGlobalNavigator
import com.space.core.navigation.requireLocalNavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import org.koin.compose.currentKoinScope
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.parameter.ParametersDefinition
import org.koin.viewmodel.defaultExtras
import org.koin.viewmodel.resolveViewModel
import kotlin.reflect.KClass

typealias VmClass<UIState, UIEvent> = KClass<out BaseVm<UIState, UIEvent>>

@OptIn(KoinInternalApi::class)
@Composable
internal fun <UIState : UiState, UIEvent : UiEvent> koinViewModel(
    vmClass: VmClass<UIState, UIEvent>,
    parameters: ParametersDefinition? = null,
): BaseVm<UIState, UIEvent> {
    val viewModelStoreOwner = LocalViewModelStoreOwner.current!!
    return resolveViewModel(
        vmClass = vmClass,
        viewModelStore = viewModelStoreOwner.viewModelStore,
        extras = defaultExtras(viewModelStoreOwner),
        scope = currentKoinScope(),
        parameters = parameters
    )
}

@Composable
internal fun NavCommands(navigationCommands: Flow<NavCommandBundle>) {
    val localNavigator = localNavigator()
    val globalNavigator = globalNavigator()

    LaunchedEffect(Unit) {
        navigationCommands.collect {
            when {
                it.flowNavigationCommand != null -> it.flowNavigationCommand!!.execute(
                    localNavigator!!
                )

                it.featureNavigationCommand != null -> it.featureNavigationCommand!!.execute(
                    globalNavigator!!
                )
            }
        }
    }
}