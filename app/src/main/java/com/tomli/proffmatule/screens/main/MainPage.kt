package com.tomli.proffmatule.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.R
import com.tomli.proffmatule.components.BannerView
import com.tomli.proffmatule.components.MenuCategoriesView
import com.tomli.proffmatule.ui.theme.Caption
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import com.tomli.uikit.cards.BottomSheet
import com.tomli.uikit.cards.CardSupply
import com.tomli.uikit.cards.CardSupplyView
import com.tomli.uikit.cards.MenuCategories
import com.tomli.uikit.search.Search
import com.tomli.uikit.theme.spProDisplayRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(navController: NavController, searchValue: String) {
    val category = remember { mutableStateOf(MenuCategories.All) }
    val isBottomSheetOpen = remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState()
    val itemsInBottomSheet = remember { mutableStateOf(
        CardSupply(0, "", 0, false, MenuCategories.All, listOf(CardSupply.DescrSections("", ""))
        )) }
    val banners = remember {
        mutableStateOf(
            listOf(
                BannerData(1, "Item1", 4000,
                    R.drawable.ic_launcher_foreground,
                    listOf(Color(0xff97D9F0), Color(0xff92E9D4))
                ),
                BannerData(2, "Item2", 8000, null, listOf(Color(0xff76B3FF), Color(0xffff006f)))
            )
        )
    }

    val cards = remember {
        mutableStateListOf(
            CardSupply(
                1,
                "Первый товар",
                1000,
                false,
                MenuCategories.Kids,
                listOf(
                    CardSupply.DescrSections("Описание", "Какое-то описание товара"),
                    CardSupply.DescrSections(
                        "Подробности",
                        "Ещё какое-то описание во втором разделе"
                    )
                )
            ),
            CardSupply(
                2,
                "Второй товар",
                2000,
                true,
                MenuCategories.Woman,
                listOf(CardSupply.DescrSections("Описание2", "Какое-то описание товара"))
            ),
            CardSupply(
                3,
                "Третий товар",
                3000,
                false,
                MenuCategories.Man,
                listOf(CardSupply.DescrSections("Описание3", "Какое-то описание товара"))
            )
        )
    }
    Column(Modifier.fillMaxWidth(1f)) {
        Column {
            Text(
                text = "Акции и новости",
                color = Caption,fontFamily= spProDisplayRegular,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)
            )
            LazyRow {
                items(items = banners.value, key = { it.id }) { item ->
                    if (banners.value.indexOf(item) == 0) {
                        Spacer(Modifier.width(20.dp))
                    }
                    BannerView(item)
                    if (banners.value.indexOf(item) == banners.value.size - 1) {
                        Spacer(Modifier.width(20.dp))
                    } else {
                        Spacer(Modifier.width(10.dp))
                    }
                }
            }
            Text(
                text = "Каталог описаний",
                color = Caption, fontFamily= spProDisplayRegular,
                fontSize = 17.sp,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 30.dp, bottom = 10.dp)
            )
            MenuCategoriesView(category.value, { newCateg -> category.value = newCateg })
            LazyColumn(modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 15.dp)) {
                items(items = cards.filter {
                    if (category.value != MenuCategories.All) {
                        it.category == category.value
                    } else {
                        true
                    }
                }, key = { it.id }) { item ->
                    Box(modifier = Modifier
                        .wrapContentSize()
                        .padding(vertical = 5.dp).clickable { itemsInBottomSheet.value=item; isBottomSheetOpen.value=true }) {
                        CardSupplyView(item, {
                            val index = cards.indexOf(cards.find { it.id == item.id })
                            cards[index] = cards[index].copy(isAdded = !cards[index].isAdded)
                        }
                        )
                    }
                }
            }
        }
    }
    if(isBottomSheetOpen.value){
        BottomSheet(itemsInBottomSheet.value, {isBottomSheetOpen.value=false}, bottomSheetState)
    }
}