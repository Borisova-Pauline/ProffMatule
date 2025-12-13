package com.tomli.proffmatule.screens.main

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.R
import com.tomli.proffmatule.components.BannerView
import com.tomli.proffmatule.components.CategoryButton
import com.tomli.proffmatule.components.MenuCategoriesView
import com.tomli.proffmatule.components.Search
import com.tomli.proffmatule.ui.theme.Caption
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme

@Composable
fun MainPage(navController: NavController){
    val searchValue= remember { mutableStateOf("") }
    val category = remember { mutableStateOf(MenuCategories.All) }
    val banners = remember { mutableStateOf(listOf(BannerData(1, "Item1", 4000, R.drawable.ic_launcher_foreground, listOf(Color(0xff97D9F0), Color(0xff92E9D4))),
        BannerData(2, "Item2", 8000, null, listOf(Color(0xff76B3FF), Color(0xffff006f)))))}

    val cards = remember{ mutableStateOf(listOf(
        CardSupply(1, "Первый товар", 1000, false, MenuCategories.Kids, listOf(CardSupply.DescrSections("Описание", "Какое-то описание товара"), CardSupply.DescrSections("Подробности", "Ещё какое-то описание во втором разделе"))),
        CardSupply(2, "Второй товар", 2000, true, MenuCategories.Woman, listOf(CardSupply.DescrSections("Описание2", "Какое-то описание товара")))
    ))}
    Column(Modifier.fillMaxWidth(1f)) {
        Search(searchValue.value, {newText ->  searchValue.value=newText}, modifier = Modifier.fillMaxWidth(1f).padding(top=20.dp, bottom = 10.dp).padding(horizontal = 20.dp))
        Column(/*modifier=Modifier.verticalScroll(rememberScrollState())*/){
            Text(text="Акции и новости", color=Caption, fontSize = 17.sp, modifier=Modifier.padding(horizontal = 20.dp).padding(top=20.dp))
            LazyRow{
                items(items=banners.value, key={it.id}){ item->
                    if(banners.value.indexOf(item)==0){
                        Spacer(Modifier.width(20.dp))
                    }
                    BannerView(item)
                    if(banners.value.indexOf(item)==banners.value.size-1){
                        Spacer(Modifier.width(20.dp))
                    }else{
                        Spacer(Modifier.width(10.dp))
                    }
                }
            }
            Text(text="Каталог описаний", color=Caption, fontSize=17.sp, modifier=Modifier.padding(horizontal = 20.dp).padding(top = 30.dp, bottom=10.dp))
            MenuCategoriesView(category.value, {newCateg -> category.value=newCateg })
            LazyColumn(modifier=Modifier.padding(horizontal = 20.dp).padding(top=20.dp)) {
                items(items=cards.value, key={it.id}){item->
                    CardSupplyView(item)
                }
            }
        }
    }
}


enum class MenuCategories{
    All, Woman, Man, Kids, Accessories
}



@Composable
fun CardSupplyView(card: CardSupply){
    Column(modifier=Modifier.width(335.dp).height(136.dp).padding(10.dp)){
        Text(text=card.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProffMatuleTheme {
        MainScreen(rememberNavController())
    }
}