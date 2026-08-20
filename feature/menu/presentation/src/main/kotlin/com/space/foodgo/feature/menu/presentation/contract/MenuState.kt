package com.space.foodgo.feature.menu.presentation.contract

import com.space.core.presentation.UiState

data class MenuState (
    val loading: Boolean = false
) : UiState