package com.tomli.proffmatule.components.bannerview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.proffmatule.screens.main.mainscreen.BannerData
import com.tomli.uikit.theme.spProDisplayRegular

@Composable
fun BannerView(banner: BannerData) {
    Row(
        modifier = Modifier
            .height(152.dp)
            .width(270.dp)
            .background(
                brush = Brush.linearGradient(colors = banner.gradient),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Column(Modifier
            .padding(16.dp)
            .width(120.dp)) {
            Text(
                text = banner.name,
                fontFamily = spProDisplayRegular,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${banner.price} ₽",
                fontFamily = spProDisplayRegular,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        when (banner.picture) {
            is Int -> {
                Image(
                    painter = painterResource(banner.picture),
                    contentScale = ContentScale.Fit,
                    contentDescription = null
                )
            }

            else -> {

            }
        }
    }
}