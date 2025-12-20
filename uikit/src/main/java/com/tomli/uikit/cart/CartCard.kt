package com.tomli.uikit.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.ColorDivider
import com.tomli.uikit.R
import com.tomli.uikit.buttons.CounterButtons
import com.tomli.uikit.theme.spProDisplayRegular

@Composable
fun CartCard(card: CardExtended, onDelete:()->Unit, onQuantityChange:(newCount: Int)->Unit){
    Column(modifier= Modifier.height(138.dp).border(
        width = 1.dp,
        color = ColorDivider,
        shape = RoundedCornerShape(12.dp)
    ).padding(15.dp)){
        Row{
            Text(text=card.baseCard.name, fontSize = 16.sp, modifier= Modifier.weight(1f), fontFamily = spProDisplayRegular, fontWeight = FontWeight(500))
            Image(painter= painterResource(R.drawable.exit_sign), contentDescription = null, modifier= Modifier.size(20.dp).clickable { onDelete() })
        }
        Spacer(modifier= Modifier.weight(1f))
        Row{
            Text(text="${card.baseCard.price} ₽", fontSize = 17.sp, modifier=Modifier.weight(1f), fontFamily = spProDisplayRegular, fontWeight = FontWeight(500))
            Text(text="${card.quantity} штук", fontSize = 15.sp, fontFamily = spProDisplayRegular)
            Spacer(modifier=Modifier.width(42.dp))
            CounterButtons(card.quantity, onQuantityChange)
        }
    }
}