package com.tomli.proffmatule.screens.main

import androidx.compose.ui.graphics.Color

data class BannerData(
    val id: Int,
    val name: String,
    val price: Int,
    val picture: Any?,
    val gradient: List<Color>
)
