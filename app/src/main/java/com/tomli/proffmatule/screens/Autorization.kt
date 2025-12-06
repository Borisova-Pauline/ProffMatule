package com.tomli.proffmatule.screens

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeDefaults.Spacing
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tomli.proffmatule.BlueButton
import com.tomli.proffmatule.ButtonEnterWith
import com.tomli.proffmatule.R
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.AccentInactive
import com.tomli.proffmatule.ui.theme.Caption
import com.tomli.proffmatule.ui.theme.Description
import com.tomli.proffmatule.ui.theme.InputBG
import com.tomli.proffmatule.ui.theme.InputIcon
import com.tomli.proffmatule.ui.theme.InputStroke
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import kotlinx.coroutines.delay

@Composable
fun EnterCode(navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).background(Color.White).fillMaxSize()){
            val code = remember{ mutableStateOf("")}
            Text(text = "Вход", fontSize = 24.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal=50.dp).fillMaxWidth().padding(top=(144.dp-innerPadding.calculateTopPadding())))
            Row(modifier = Modifier.padding(horizontal=138.dp).fillMaxWidth().
            padding(top=(264.dp-innerPadding.calculateTopPadding())).height(16.dp), horizontalArrangement = Arrangement.Center){
                val density= LocalDensity.current
                val radius= with(density){8.dp.toPx()}
                val stroke = 1
                DotCode(radius, stroke, 1, code.value.length)
                Spacer(modifier=Modifier.width(28.dp))
                DotCode(radius, stroke, 2, code.value.length)
                Spacer(modifier=Modifier.width(28.dp))
                DotCode(radius, stroke, 3, code.value.length)
                Spacer(modifier=Modifier.width(28.dp))
                DotCode(radius, stroke, 4, code.value.length)
            }
            Column(modifier=Modifier.padding(horizontal = 43.dp).padding(top=(340.dp-innerPadding.calculateTopPadding()))){
                Row(horizontalArrangement = Arrangement.Center, modifier=Modifier.fillMaxWidth()){
                    NumberInCircle(80, "1", {code.value= CodeAdder(code.value, 4, "1")})
                    Spacer(modifier=Modifier.width(24.dp))
                    NumberInCircle(80, "2", {code.value= CodeAdder(code.value, 4, "2")})
                    Spacer(modifier=Modifier.width(24.dp))
                    NumberInCircle(80, "3", {code.value= CodeAdder(code.value, 4, "3")})
                }
                Spacer(modifier=Modifier.height(24.dp))
                Row(horizontalArrangement = Arrangement.Center, modifier=Modifier.fillMaxWidth()){
                    NumberInCircle(80, "4", {code.value= CodeAdder(code.value, 4, "4")})
                    Spacer(modifier=Modifier.width(24.dp))
                    NumberInCircle(80, "5", {code.value= CodeAdder(code.value, 4, "5")})
                    Spacer(modifier=Modifier.width(24.dp))
                    NumberInCircle(80, "6", {code.value= CodeAdder(code.value, 4, "6")})
                }
                Spacer(modifier=Modifier.height(24.dp))
                Row(horizontalArrangement = Arrangement.Center, modifier=Modifier.fillMaxWidth()){
                    NumberInCircle(80, "7", {code.value= CodeAdder(code.value, 4, "7")})
                    Spacer(modifier=Modifier.width(24.dp))
                    NumberInCircle(80, "8", {code.value= CodeAdder(code.value, 4, "8")})
                    Spacer(modifier=Modifier.width(24.dp))
                    NumberInCircle(80, "9", {code.value= CodeAdder(code.value, 4, "9")})
                }
                Spacer(modifier=Modifier.height(24.dp))
                Row(horizontalArrangement = Arrangement.Center, modifier=Modifier.fillMaxWidth()){
                    Spacer(modifier=Modifier.size(80.dp))
                    Spacer(modifier=Modifier.width(24.dp))
                    NumberInCircle(80, "0", {code.value= CodeAdder(code.value, 4, "0")})
                    Spacer(modifier=Modifier.width(24.dp))
                    Image(painter = painterResource(R.drawable.delicion), contentDescription = null,
                        modifier = Modifier.size(80.dp).padding(20.dp).clickable{code.value=code.value.dropLast(1)})
                }
            }
        }
    }
}

fun CodeAdder(code: String, maxLength: Int, pressedVal: String): String{
    if(code.length>=maxLength){
        return code
    }else{
        return code+pressedVal
    }
}

@Composable
fun NumberInCircle(radius: Int, number: String, onClick:()->Unit){
    val density= LocalDensity.current
    val radiusPx= with(density){radius.dp.toPx()/2}
    val interaction = remember{ MutableInteractionSource()}
    var isPressed = interaction.collectIsPressedAsState()
    Box(modifier = Modifier.size(radius.dp)){
        Canvas(modifier = Modifier.fillMaxSize().clickable(interactionSource = interaction, indication = null) { onClick() }) {
            val center = Offset(size.width/2f, size.height/2f)
            drawCircle(color= if(isPressed.value) Accent else InputBG, radius = radiusPx, center=center)
        }
        Text(text=number, fontSize = 24.sp, modifier=Modifier.align(Alignment.Center))
    }
}


@Composable
fun DotCode(radius: Float, stroke: Int, ordinal: Int, numCode: Int){
    Canvas(modifier = Modifier.fillMaxHeight()) {
        val center = Offset(size.width/2f, size.height/2f)
        if(numCode>=ordinal){
            drawCircle(color= Accent, radius = radius, center=center)
        }
        drawCircle(color=Accent, radius = radius, center=center, style= Stroke(width=stroke.dp.toPx()))
    }
}


@Composable
fun EnterRegistrated(navController: NavController){
    val context= LocalContext.current
    val email= remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).background(Color.White).fillMaxSize()) {
            Column(modifier=Modifier.padding(horizontal = 20.dp).padding(top=103.dp-innerPadding.calculateTopPadding())){
                Row(modifier = Modifier.padding(bottom=23.dp)){
                    Image(painter= painterResource(R.drawable.emoji_hello),contentDescription = null, modifier = Modifier.padding(end=16.dp).size(32.dp))
                    Text(text="Добро пожаловать!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                Text(text="Войдите, чтобы пользоваться функциями приложения", fontSize=15.sp)
            }
            Column(modifier=Modifier.padding(horizontal = 20.dp).padding(top=262.dp-innerPadding.calculateTopPadding())){
                Text(text="Вход по E-mail", color= Description)
                SimpleInput(email.value, {newText->email.value=newText}, "example@mail.com")
                Spacer(modifier=Modifier.height(10.dp))
                Text(text="Пароль", color= Description)
                PasswordInput(password.value, {newText->password.value=newText}, "", R.drawable.hide_password, R.drawable.show_password)
                Spacer(modifier=Modifier.height(10.dp))
                if(email.value==""||password.value==""){
                    BlueButton("Далее", {Toast.makeText(context, "Вы не ввели данные", Toast.LENGTH_LONG).show()},
                        AccentInactive, modifier=Modifier.height(56.dp).fillMaxWidth())
                }else{
                    BlueButton("Далее", {Toast.makeText(context, "Вход", Toast.LENGTH_LONG).show()},
                        Accent, modifier=Modifier.height(56.dp).fillMaxWidth())
                }
                Spacer(modifier=Modifier.height(10.dp))
                Text(text="Зарегистрироваться", fontSize = 15.sp, color=Accent, textAlign = TextAlign.Center,
                    modifier=Modifier.fillMaxWidth())
            }
            Column(modifier=Modifier.padding(horizontal = 20.dp).padding(top=584.dp-innerPadding.calculateTopPadding())){
                Text(text="Или войдите с помощью", fontSize = 15.sp, color= Caption, textAlign = TextAlign.Center,
                    modifier=Modifier.fillMaxWidth())
                Spacer(modifier=Modifier.height(12.dp))
                ButtonEnterWith(modifier=Modifier.height(56.dp).fillMaxWidth(), {Toast.makeText(context, "Вход через ВК", Toast.LENGTH_LONG).show()}, R.drawable.vk_logo, "Войти с VK")
                Spacer(modifier=Modifier.height(12.dp))
                ButtonEnterWith(modifier=Modifier.height(56.dp).fillMaxWidth(), {Toast.makeText(context, "Вход через Яндекс", Toast.LENGTH_LONG).show()}, R.drawable.yandex_logo, "Войти с Yandex")
            }
        }
    }
}


@Composable
fun SimpleInput(valueO: String, onChangeVal:(String)->Unit, textPlaceHolder: String){
    OutlinedTextField(value = valueO, onValueChange = onChangeVal,
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
        shape = RoundedCornerShape(10.dp),
        placeholder = { Text(text = textPlaceHolder, color=InputIcon) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Accent, unfocusedBorderColor = InputStroke,
            cursorColor = Accent,
            unfocusedContainerColor = InputBG, focusedContainerColor = InputBG
        ))
}

@Composable
fun PasswordInput(valueO: String, onChangeVal:(String)->Unit, textPlaceHolder: String, picNotShow:Int, picShow:Int){
    val hidePassword= remember { mutableStateOf(true) }
    OutlinedTextField(value = valueO, onValueChange = onChangeVal,
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
        shape = RoundedCornerShape(10.dp),
        trailingIcon = { Image(painter = if(hidePassword.value) painterResource(picNotShow) else painterResource(picShow),
            contentDescription = null, modifier = Modifier.padding(15.dp).size(20.dp).clickable { hidePassword.value=!hidePassword.value }) },
        placeholder = { Text(text = textPlaceHolder, color=Color(0xffabacb1)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Accent, unfocusedBorderColor = InputStroke,
            cursorColor = Accent,
            unfocusedContainerColor = InputBG, focusedContainerColor = InputBG
        ), visualTransformation = if(hidePassword.value) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None})
}








@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProffMatuleTheme {
        EnterRegistrated(navController = rememberNavController())
    }
}