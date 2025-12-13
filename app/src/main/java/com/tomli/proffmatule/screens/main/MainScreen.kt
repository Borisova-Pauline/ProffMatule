package com.tomli.proffmatule.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.R
import com.tomli.proffmatule.components.ButtonNavigationApp
import com.tomli.proffmatule.components.Tabbar
import com.tomli.proffmatule.screens.registration.CreatingProfile
import com.tomli.proffmatule.screens.registration.EnterCode
import com.tomli.proffmatule.screens.registration.EnterRegistrated
import com.tomli.proffmatule.ui.theme.InputStroke
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme

@Composable
fun MainScreen(navController: NavController){
    val screen = remember{ mutableStateOf(AppScreens.Main)}
    Scaffold(modifier=Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .background(Color.White)
            .fillMaxSize()) {
            Column(modifier=Modifier.fillMaxSize(1f)){
                when(screen.value){
                    AppScreens.Main ->{
                        MainPage(navController)
                    }
                    AppScreens.Catalog->{

                    }
                    AppScreens.Projects->{

                    }
                    AppScreens.Profile->{
                        ProfileScreen(navController)
                    }
                }
            }
            Tabbar(modifier= Modifier.align(Alignment.BottomCenter), screen.value, {newScreen ->  screen.value=newScreen})
        }
    }
}



enum class AppScreens{
    Main, Catalog, Projects, Profile
}








/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProffMatuleTheme {
        CreatingProfile(rememberNavController())
    }
}*/