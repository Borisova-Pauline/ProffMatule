package com.tomli.proffmatule.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.proffmatule.screens.main.AppScreens

@Composable
fun ButtonNavigationApp(boxModifier: Modifier, screenVal: AppScreens, onScreenValChange:()->Unit, text: String, activePic: Int, unactivePic: Int, needScreenValue: AppScreens){
    Box(modifier = boxModifier){
        Column(modifier= Modifier.fillMaxSize().padding(7.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter= painterResource(if(screenVal==needScreenValue)
                activePic else unactivePic), contentDescription = null,
                modifier = Modifier.clickable {onScreenValChange()}.size(32.dp))
            Text(text=text, color=if(screenVal==needScreenValue)
                Color(0xff1A6FEE) else Color(0xffB8C1CC), fontSize = 12.sp)
        }
    }
}