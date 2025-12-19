package com.tomli.uikit.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tomli.uikit.Caption
import com.tomli.uikit.InputBG
import com.tomli.uikit.InputIcon
import com.tomli.uikit.InputStroke
import com.tomli.uikit.R

@Composable
fun CounterButtons(quantity: Int, onChange:(newQuantity: Int)-> Unit){
    Box(modifier= Modifier.height(32.dp).width(64.dp).background(color= InputBG, shape = RoundedCornerShape(8.dp)), contentAlignment = Alignment.Center){
        Row(modifier= Modifier.padding(horizontal = 6.dp)){
            Image(painter = painterResource(R.drawable.minus), contentDescription = null, modifier= Modifier.clickable { if(quantity>1){
                onChange(quantity.minus(1))
            }}.size(20.dp), colorFilter = ColorFilter.tint(if(quantity<=1){ InputIcon
            }else{
                Caption
            }))
            Box(modifier= Modifier.weight(1f), contentAlignment = Alignment.Center){
                VerticalDivider(color= InputStroke, modifier= Modifier.width(1.dp).height(16.dp))
            }
            Image(painter = painterResource(R.drawable.plus), contentDescription = null, modifier= Modifier.clickable { onChange(quantity.plus(1)) }.size(20.dp),
                colorFilter = ColorFilter.tint(Caption))
        }
    }
}