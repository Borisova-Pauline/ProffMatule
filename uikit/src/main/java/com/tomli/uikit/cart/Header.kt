package com.tomli.uikit.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.R
import com.tomli.uikit.theme.spProDisplayRegular

@Composable
fun Header(modifier: Modifier, onBackClick:()->Unit, onDeleteClick:()->Unit){
    Column(modifier=modifier){
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter= painterResource(R.drawable.back_button), contentDescription = null, modifier = Modifier.size(32.dp).clickable { onBackClick() })
            Spacer(modifier = Modifier.weight(1f))
            Image(painter= painterResource(R.drawable.delete_button), contentDescription = null, modifier = Modifier.size(20.dp).clickable { onDeleteClick() })
        }
        Text(text="Корзина", fontSize = 24.sp, fontWeight = FontWeight(700), modifier = Modifier.padding(top=15.dp), fontFamily = spProDisplayRegular)
    }
}