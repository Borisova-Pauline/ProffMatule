package com.tomli.uikit.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.InputStroke

@Composable
fun ButtonEnterWith(modifier: Modifier, onClick: () -> Unit, icon: Int, text: String){
    Button(onClick = {onClick()},
        colors= ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = RoundedCornerShape(10.dp), modifier=modifier,
        border = BorderStroke(width= 1.dp, color= InputStroke)
    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter= painterResource(icon), contentDescription = null, modifier= Modifier.size(32.dp))
            Spacer(modifier= Modifier.width(16.dp))
            Text(text=text, fontSize = 17.sp, color = Color.Black)
        }
    }
}