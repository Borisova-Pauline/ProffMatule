package com.tomli.proffmatule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.screens.SplashScreen
import com.tomli.proffmatule.screens.main.BasketScreen
import com.tomli.proffmatule.screens.main.MainScreen
import com.tomli.proffmatule.screens.registration.EnterCode
import com.tomli.proffmatule.screens.registration.CreateCode
import com.tomli.proffmatule.screens.registration.CreatePassword
import com.tomli.proffmatule.screens.registration.CreatingProfile
import com.tomli.proffmatule.screens.registration.EnterRegistrated
import com.tomli.proffmatule.ui.theme.InputStroke
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val showSplash = remember{ mutableStateOf(true)}
            ProffMatuleTheme {
                if(showSplash.value){
                    SplashScreen{ showSplash.value=false }
                }else{
                    NavigationFun()
                }
            }
        }
    }
}


@Composable
fun NavigationFun(){
    val navController = rememberNavController()
    NavHost(
        navController=navController,
        startDestination = "mainScreen" //"enterIfRegistrated"
    ) {
        composable("enterCode"){
            EnterCode(navController = navController)
        }
        composable("enterIfRegistrated") {
            EnterRegistrated(navController)
        }
        composable("createProfile") {
            CreatingProfile(navController)
        }
        composable("CreatePassword"){
            CreatePassword(navController)
        }
        composable("createCode"){
            CreateCode(navController)
        }
        composable("mainScreen"){
            MainScreen(navController)
        }
        composable("basketScreen") {
            BasketScreen(navController)
        }
    }
}