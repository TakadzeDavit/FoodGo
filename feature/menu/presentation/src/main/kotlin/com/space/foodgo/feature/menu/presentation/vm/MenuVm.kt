package com.space.foodgo.feature.menu.presentation.vm

import com.space.core.presentation.BaseVm
import com.space.foodgo.feature.menu.presentation.contract.MenuEvent
import com.space.foodgo.feature.menu.presentation.contract.MenuState

class MenuVm : BaseVm<MenuState, MenuEvent>(MenuState()){
    override fun onEvent(event: MenuEvent) {

    }

}