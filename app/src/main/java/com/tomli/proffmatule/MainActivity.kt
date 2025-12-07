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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.screens.CreatePassword
import com.tomli.proffmatule.screens.CreatingProfile
import com.tomli.proffmatule.screens.EnterCode
import com.tomli.proffmatule.screens.EnterRegistrated
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.InputStroke
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showSplash = remember{ mutableStateOf(true)}
            ProffMatuleTheme {
                if(showSplash.value){
                    SplashScreen { showSplash.value=false }
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
        startDestination = "CreatePassword"
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
    }
}


@Composable
fun BlueButton(text: String, onClick:()->Unit, colorButton: Color,modifier: Modifier){
    Button(onClick = {onClick()},
        colors=ButtonDefaults.buttonColors(containerColor = colorButton, contentColor = Color.White),
        shape = RoundedCornerShape(10.dp), modifier=modifier){
        Text(text=text, fontSize = 17.sp)
    }
}


@Composable
fun ButtonEnterWith(modifier: Modifier, onClick: () -> Unit, icon: Int, text: String){
    Button(onClick = {onClick()},
        colors=ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = RoundedCornerShape(10.dp), modifier=modifier,
        border = BorderStroke(width= 1.dp, color= InputStroke)
    ){
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter= painterResource(icon), contentDescription = null, modifier=Modifier.size(32.dp))
            Spacer(modifier=Modifier.width(16.dp))
            Text(text=text, fontSize = 17.sp, color = Color.Black)
        }
    }
}




@Composable
fun SplashScreen(onDataLoaded:()->Unit){
    LaunchedEffect(Unit) {
        delay(2000)
        onDataLoaded()
    }
    Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Image(painter = painterResource(R.drawable.splash_screen), contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
    }
}