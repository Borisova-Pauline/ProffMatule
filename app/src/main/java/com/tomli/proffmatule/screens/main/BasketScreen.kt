package com.tomli.proffmatule.screens.main

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import com.tomli.uikit.Accent
import com.tomli.uikit.buttons.BlueButton
import com.tomli.uikit.cards.CardSupply
import com.tomli.uikit.cards.MenuCategories
import com.tomli.uikit.cart.CardExtended
import com.tomli.uikit.cart.CartCard
import com.tomli.uikit.cart.Header

@Composable
fun BasketScreen(navController: NavController){
    val context = LocalContext.current
    val cards = remember {
        mutableStateListOf(
            CardExtended(CardSupply(
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
            ), 1),
            CardExtended(CardSupply(
                2,
                "Второй товар",
                2000,
                true,
                MenuCategories.Woman,
                listOf(CardSupply.DescrSections("Описание2", "Какое-то описание товара"))
            ), 1),
            CardExtended(CardSupply(
                3,
                "Третий товар",
                3000,
                false,
                MenuCategories.Man,
                listOf(CardSupply.DescrSections("Описание3", "Какое-то описание товара"))
            ), 2)
        )
    }
    val priceCount = countAllPrice(cards)
    Scaffold(modifier= Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.White)
                .fillMaxSize().padding(horizontal = 20.dp)
        ) {
            Header(modifier = Modifier.fillMaxWidth().padding(top=15.dp, bottom=5.dp),{navController.navigateUp()}, {})
            Column{
                LazyColumn(modifier=Modifier.weight(1f, false)) {
                    items(items = cards, key = { it.baseCard.id }){item->
                        Box(modifier=Modifier.wrapContentSize().padding(vertical=15.dp)){
                            CartCard(item, {
                                val index = cards.indexOf(cards.find { it.baseCard.id == item.baseCard.id })
                                cards.remove(cards[index])
                            },{newCount->
                                val index = cards.indexOf(cards.find { it.baseCard.id == item.baseCard.id })
                                cards[index] = cards[index].copy(quantity = newCount)})
                        }
                    }
                }
                Row{
                    Text(text="Сумма", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier=Modifier.weight(1f))
                    Text(text="$priceCount ₽", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier=Modifier.height(10.dp))
            }
            Spacer(modifier=Modifier.weight(1f))
            BlueButton("Перейти к оформлению заказа", {
                Toast.makeText(context, "Переход к оформлению заказа", Toast.LENGTH_LONG).show()
            }, Accent, modifier = Modifier.fillMaxWidth().padding(bottom=10.dp).height(56.dp))
        }
    }
}

fun countAllPrice(cardExtended: List<CardExtended>): Int{
    var finalPrice = 0
    cardExtended.forEach{ card->
        finalPrice+= (card.quantity * card.baseCard.price)
    }
    return finalPrice
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProffMatuleTheme {
        BasketScreen(rememberNavController())
    }
}