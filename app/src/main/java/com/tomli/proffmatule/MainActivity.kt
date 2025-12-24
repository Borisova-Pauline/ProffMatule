package com.tomli.proffmatule

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.screens.splashscreen.SplashScreen
import com.tomli.proffmatule.screens.main.basketscreen.BasketScreen
import com.tomli.proffmatule.screens.main.mainscreen.MainScreen
import com.tomli.proffmatule.screens.registration.pincode.entercode.EnterCode
import com.tomli.proffmatule.screens.registration.pincode.createcode.CreateCode
import com.tomli.proffmatule.screens.registration.createuser.createpassword.CreatePassword
import com.tomli.proffmatule.screens.registration.createuser.createprofile.CreatingProfile
import com.tomli.proffmatule.screens.registration.enterregistrated.EnterRegistrated
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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


@RequiresApi(Build.VERSION_CODES.O)
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