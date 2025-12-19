package com.tomli.proffmatule.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tomli.proffmatule.R
import com.tomli.uikit.search.Search
import com.tomli.uikit.tabbar.AppScreens
import com.tomli.uikit.tabbar.Tabbar

@Composable
fun MainScreen(navController: NavController){
    val screen = remember{ mutableStateOf(AppScreens.Catalog)}
    val searchValue = remember { mutableStateOf("") }
    Scaffold(modifier=Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .background(Color.White)
            .fillMaxSize()) {
            Column(modifier=Modifier.weight(1f)){
                if(screen.value==AppScreens.Main || screen.value==AppScreens.Catalog){
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Search(
                            searchValue.value,
                            { newText -> searchValue.value = newText
                            if(screen.value!=AppScreens.Catalog){
                                screen.value=AppScreens.Catalog
                            }},
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 20.dp, bottom = 10.dp)
                                .padding(horizontal = 20.dp)
                        )
                        if(screen.value==AppScreens.Catalog){
                            Image(painter = painterResource(R.drawable.profile_image), contentDescription = null, modifier=Modifier.padding(start=15.dp,end = 20.dp).size(36.dp))
                        }

                    }
                    when(screen.value){
                        AppScreens.Main ->{
                            MainPage(navController, searchValue.value)
                        }
                        AppScreens.Catalog->{
                            CatalogPage(navController, searchValue.value)
                        }
                        else ->{}
                    }
                }else{
                    when(screen.value){
                        AppScreens.Projects->{

                        }
                        AppScreens.Profile->{
                            ProfileScreen(navController)
                        }
                        else->{}
                    }
                }
            }
            Tabbar(modifier= Modifier, screen.value, {newScreen ->  screen.value=newScreen})
        }
    }
}








/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProffMatuleTheme {
        MainScreen(rememberNavController())
    }
}*/