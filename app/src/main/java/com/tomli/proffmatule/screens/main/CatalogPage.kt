package com.tomli.proffmatule.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.components.MenuCategoriesView
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import com.tomli.uikit.buttons.ButtonBasket
import com.tomli.uikit.cards.BottomSheet
import com.tomli.uikit.cards.CardSupply
import com.tomli.uikit.cards.CardSupplyView
import com.tomli.uikit.cards.MenuCategories

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogPage(navController: NavController, searchValue: String){
    val category = remember { mutableStateOf(MenuCategories.All) }
    val priceCounter = remember { mutableMapOf<Int, Int>() }
    val isBottomSheetOpen = remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState()
    val itemsInBottomSheet = remember { mutableStateOf(
        CardSupply(0, "", 0, false, MenuCategories.All, listOf(CardSupply.DescrSections("", "")))
    ) }
    val cards = remember {
        mutableStateListOf(
            CardSupply(
                1,
                "Первый товар",
                1000,
                false,
                MenuCategories.Kids,
                listOf(
                    CardSupply.DescrSections("Описание", "Какое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара"),
                    CardSupply.DescrSections(
                        "Подробности",
                        "Ещё какое-то описание во втором разделе"
                    ),CardSupply.DescrSections("Описание", "Какое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара"),
                    CardSupply.DescrSections("Описание", "Какое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара\nКакое-то описание товара")
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
        MenuCategoriesView(category.value, { newCateg -> category.value = newCateg })
        cards.forEach{item->
            if(item.isAdded){
                priceCounter.put(item.id, item.price)
            }else{
                priceCounter.remove(item.id)
            }
        }
        Box(modifier=Modifier.weight(1f)){
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
                        .padding(vertical = 5.dp).clickable {
                            itemsInBottomSheet.value = item; isBottomSheetOpen.value = true
                        }) {
                        CardSupplyView(item, {
                            val index = cards.indexOf(cards.find { it.id == item.id })
                            cards[index] = cards[index].copy(isAdded = !cards[index].isAdded)
                        })
                    }
                }
            }
        }
        ButtonBasket({navController.navigate("basketScreen")}, Accent, Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 20.dp), priceCounter.values.sum())
    }
    if(isBottomSheetOpen.value){
        BottomSheet(itemsInBottomSheet.value, {isBottomSheetOpen.value=false}, bottomSheetState)
    }
}