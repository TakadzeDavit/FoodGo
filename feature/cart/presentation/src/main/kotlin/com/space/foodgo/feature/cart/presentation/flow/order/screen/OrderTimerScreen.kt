package com.space.foodgo.feature.cart.presentation.flow.order.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.space.core.presentation.common.BaseScreen
import com.space.core.ui.component.FoodGoPrimaryButton
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Sizing
import com.space.core.ui.theme.Spacing
import com.space.foodgo.feature.cart.presentation.R
import com.space.foodgo.feature.cart.presentation.flow.order.component.WaterTimerView
import com.space.foodgo.feature.cart.presentation.flow.order.contract.OrderTimerEvent
import com.space.foodgo.feature.cart.presentation.flow.order.contract.OrderTimerState
import com.space.foodgo.feature.cart.presentation.flow.order.vm.OrderTimerVm

@Composable
fun OrderTimerScreen() {
    BaseScreen(
        vmClass = OrderTimerVm::class,
        content = { state, onEvent ->
            OrderTimerContent(
                state = state,
                onEvent = onEvent
            )
        }
    )
}

@Composable
private fun OrderTimerContent(
    state: OrderTimerState,
    onEvent: (OrderTimerEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.background)
            .systemBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = Spacing.spacing22),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(Spacing.spacing64))

        Text(
            text = if (state.isFinished) {
                stringResource(R.string.your_order_is_ready)
            } else {
                stringResource(R.string.preparing_your_order)
            },
            style = typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = colors.textPrimary
        )

        Spacer(modifier = Modifier.height(Spacing.spacing8))

        Text(
            text = stringResource(R.string.estimated_delivery_time),
            style = typography.bodyMedium,
            color = colors.textSecondary
        )

        Spacer(modifier = Modifier.height(Spacing.spacing42))

        WaterTimerView(
            progress = state.progress,
            label = state.timeLabel,
            sublabel = stringResource(R.string.min),
            modifier = Modifier.size(Sizing.size220)
        )

        Spacer(modifier = Modifier.height(Spacing.spacing36))

        if (state.isFinished) {
            Text(
                text = stringResource(R.string.order_ready),
                style = typography.bodyMedium,
                color = colors.textSecondary
            )

            Spacer(modifier = Modifier.weight(1f))

            FoodGoPrimaryButton(
                text = stringResource(R.string.back_to_home),
                onClick = { onEvent(OrderTimerEvent.OnFinishOrderClick) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Sizing.size52)
            )

            Spacer(modifier = Modifier.height(Spacing.spacing22))
        }
    }
}