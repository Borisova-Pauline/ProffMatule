package com.tomli.uikit.tabbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tomli.uikit.InputStroke
import com.tomli.uikit.R

@Composable
fun Tabbar(
    modifier: Modifier,
    screen: AppScreens,
    onScreenChange: (newScreen: AppScreens) -> Unit
) {
    Column(modifier = modifier.background(Color.White)) {
        HorizontalDivider(thickness = 1.dp, color = InputStroke)
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)) {
            ButtonNavigationApp(
                boxModifier = Modifier.weight(1f),
                screen,
                { onScreenChange(AppScreens.Main) },
                "Главная",
                R.drawable.main_active,
                R.drawable.main_unactive,
                AppScreens.Main
            )
            ButtonNavigationApp(
                boxModifier = Modifier.weight(1f),
                screen,
                { onScreenChange(AppScreens.Catalog) },
                "Каталог",
                R.drawable.catalog_active,
                R.drawable.catalog_unactive,
                AppScreens.Catalog
            )
            ButtonNavigationApp(
                boxModifier = Modifier.weight(1f),
                screen,
                { onScreenChange(AppScreens.Projects) },
                "Проекты",
                R.drawable.projects_active,
                R.drawable.projects_unactive,
                AppScreens.Projects
            )
            ButtonNavigationApp(
                boxModifier = Modifier.weight(1f),
                screen,
                { onScreenChange(AppScreens.Profile) },
                "Профиль",
                R.drawable.user_active,
                R.drawable.user_unactive,
                AppScreens.Profile
            )
        }
    }
}