package com.space.foodgo.feature.cart.presentation.flow.cart.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.FoodGoTheme.typography
import com.space.core.ui.theme.Sizing
import com.space.core.ui.theme.Spacing
import com.space.foodgo.feature.cart.presentation.R

@Composable
fun CartTopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacing12),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            tint = colors.textPrimary,
            modifier = Modifier
                .size(Sizing.size20)
                .clickable { onBackClick() }
        )

        Spacer(modifier = Modifier.width(Spacing.spacing12))

        Text(
            text = title,
            style = typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = colors.textPrimary
        )
    }
}