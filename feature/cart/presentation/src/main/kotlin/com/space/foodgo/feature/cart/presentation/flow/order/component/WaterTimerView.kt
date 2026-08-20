package com.space.foodgo.feature.cart.presentation.flow.order.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.space.core.ui.theme.FoodGoTheme.colors
import com.space.core.ui.theme.Sizing
import com.space.core.ui.theme.Spacing
import com.space.core.ui.theme.TextSizing
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun WaterTimerView(
    progress: Float,
    label: String,
    sublabel: String,
    modifier: Modifier = Modifier
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
        label = "waterLevel"
    )

    val infiniteTransition = rememberInfiniteTransition(label = "wavePhase")
    val wavePhase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = (2 * PI).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2200, easing = LinearEasing)
        ),
        label = "wavePhase"
    )

    Box(
        modifier = modifier
            .size(Sizing.size220)
            .clip(CircleShape)
            .background(Color(0xFF1E2856))
            .border(
                width = Sizing.size4,
                color = Color.White.copy(alpha = 0.15f),
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val waterTopY = size.height * (1f - animatedProgress)
            val amplitude = 8.dp.toPx()
            val waveLength = size.width

            val backPath = Path().apply {
                moveTo(0f, waterTopY)
                var x = 0f
                while (x <= size.width) {
                    val angle = (x / waveLength) * 2 * PI + wavePhase + (PI / 2)
                    val y = waterTopY + sin(angle).toFloat() * (amplitude * 0.7f)
                    lineTo(x, y)
                    x += 4f
                }
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            drawPath(path = backPath, color = Color(0xFF3B82F6).copy(alpha = 0.5f))

            val frontPath = Path().apply {
                moveTo(0f, waterTopY)
                var x = 0f
                while (x <= size.width) {
                    val angle = (x / waveLength) * 2 * PI + wavePhase
                    val y = waterTopY + sin(angle).toFloat() * amplitude
                    lineTo(x, y)
                    x += 4f
                }
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            drawPath(path = frontPath, color = Color(0xFF3B82F6))
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                color = colors.onPrimary,
                fontSize = 40.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(Spacing.spacing4))

            Text(
                text = sublabel,
                color = Color.White.copy(alpha = 0.7f),
                fontSize = TextSizing.size14,
                fontWeight = FontWeight.Normal
            )
        }
    }
}