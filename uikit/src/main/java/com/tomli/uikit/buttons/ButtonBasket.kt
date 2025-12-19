package com.tomli.uikit.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.R

@Composable
fun ButtonBasket(onClick:()->Unit, colorButton: Color, modifier: Modifier, totalPrice: Int){
    Button(onClick = {onClick()},
        colors= ButtonDefaults.buttonColors(containerColor = colorButton, contentColor = Color.White),
        shape = RoundedCornerShape(10.dp), modifier=modifier){
        Row(modifier= Modifier.padding(horizontal = 10.dp, vertical = 15.dp)){
            Image(painter = painterResource(R.drawable.basket), contentDescription = null, modifier= Modifier.size(20.dp))
            Spacer(Modifier.width(16.dp))
            Text(text="В корзину", fontSize = 17.sp, modifier= Modifier.weight(1f))
            Text(text="$totalPrice ₽", fontSize = 17.sp)
        }
    }
}