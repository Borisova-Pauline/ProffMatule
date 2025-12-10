package com.tomli.proffmatule.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.tomli.proffmatule.ui.theme.Accent

@Composable
fun DotCode(radius: Float, stroke: Int, ordinal: Int, numCode: Int) {
    Canvas(modifier = Modifier.fillMaxHeight()) {
        val center = Offset(size.width / 2f, size.height / 2f)
        if (numCode >= ordinal) {
            drawCircle(color = Accent, radius = radius, center = center)
        }
        drawCircle(
            color = Accent,
            radius = radius,
            center = center,
            style = Stroke(width = stroke.dp.toPx())
        )
    }
}