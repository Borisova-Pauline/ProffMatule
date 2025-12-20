package com.tomli.proffmatule.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import com.tomli.uikit.theme.robotoFont
import com.tomli.uikit.theme.spProDisplayRegular

@Composable
fun ProjectPage(navController: NavController){
    val isCreating = remember { mutableStateOf(false) }
    Column(modifier= Modifier.fillMaxWidth().padding(20.dp)){
        if(isCreating.value){

        }else{
            Box(modifier=Modifier.padding(top=20.dp, bottom=30.dp)){
                Text(text="Проекты", fontFamily= robotoFont, fontSize=20.sp, fontWeight = FontWeight(600), textAlign = TextAlign.Center, modifier= Modifier.fillMaxWidth())
                Image(painter= painterResource(com.tomli.uikit.R.drawable.plus), contentDescription = null, modifier= Modifier.align(Alignment.CenterEnd).size(20.dp))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProffMatuleTheme {
        MainScreen(rememberNavController())
    }
}