package com.tomli.uikit.cards.category

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuCategoriesView(category: MenuCategories, categoryChange:(newCateg: MenuCategories)->Unit){
    Row(modifier= Modifier.horizontalScroll(rememberScrollState())){
        Spacer(Modifier.width(20.dp))
        CategoryButton("Все", {categoryChange(MenuCategories.All)}, MenuCategories.All, category)
        Spacer(Modifier.width(10.dp))
        CategoryButton("Женщинам", {categoryChange(MenuCategories.Woman)}, MenuCategories.Woman, category)
        Spacer(Modifier.width(10.dp))
        CategoryButton("Мужчинам", {categoryChange(MenuCategories.Man)}, MenuCategories.Man, category)
        Spacer(Modifier.width(10.dp))
        CategoryButton("Детям", {categoryChange(MenuCategories.Kids)}, MenuCategories.Kids, category)
        Spacer(Modifier.width(10.dp))
        CategoryButton("Аксессуары", {categoryChange(MenuCategories.Accessories)}, MenuCategories.Accessories, category)
        Spacer(Modifier.width(20.dp))
    }
}