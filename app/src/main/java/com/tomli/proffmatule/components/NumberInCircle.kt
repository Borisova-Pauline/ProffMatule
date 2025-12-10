package com.tomli.proffmatule.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.InputBG

@Composable
fun NumberInCircle(radius: Int, number: String, onClick: () -> Unit) {
    val density = LocalDensity.current
    val radiusPx = with(density) { radius.dp.toPx() / 2 }
    val interaction = remember { MutableInteractionSource() }
    var isPressed = interaction.collectIsPressedAsState()
    Box(modifier = Modifier.size(radius.dp)) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .clickable(interactionSource = interaction, indication = null) { onClick() }) {
            val center = Offset(size.width / 2f, size.height / 2f)
            drawCircle(
                color = if (isPressed.value) Accent else InputBG,
                radius = radiusPx,
                center = center
            )
        }
        Text(text = number, fontSize = 24.sp, modifier = Modifier.align(Alignment.Center))
    }
}