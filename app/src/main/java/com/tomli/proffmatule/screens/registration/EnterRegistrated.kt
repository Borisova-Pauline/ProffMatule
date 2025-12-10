package com.tomli.proffmatule.screens.registration

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tomli.proffmatule.R
import com.tomli.proffmatule.components.BlueButton
import com.tomli.proffmatule.components.ButtonEnterWith
import com.tomli.proffmatule.components.PasswordInput
import com.tomli.proffmatule.components.SimpleInput
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.AccentInactive
import com.tomli.proffmatule.ui.theme.Caption
import com.tomli.proffmatule.ui.theme.Description

@Composable
fun EnterRegistrated(navController: NavController) {
    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .background(Color.White)
            .fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 103.dp - innerPadding.calculateTopPadding())
            ) {
                Row(modifier = Modifier.padding(bottom = 23.dp)) {
                    Image(
                        painter = painterResource(R.drawable.emoji_hello),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(32.dp)
                    )
                    Text(text = "Добро пожаловать!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                Text(text = "Войдите, чтобы пользоваться функциями приложения", fontSize = 15.sp)
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 262.dp - innerPadding.calculateTopPadding())
            ) {
                Text(text = "Вход по E-mail", color = Description, fontSize = 14.sp)
                SimpleInput(email.value, { newText -> email.value = newText }, "example@mail.com")
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Пароль", color = Description, fontSize = 14.sp)
                PasswordInput(
                    password.value,
                    { newText -> password.value = newText },
                    "",
                    R.drawable.hide_password,
                    R.drawable.show_password
                )
                Spacer(modifier = Modifier.height(15.dp))
                if (email.value == "" || password.value == "") {
                    BlueButton(
                        "Далее",
                        { Toast.makeText(context, "Вы не ввели данные", Toast.LENGTH_LONG).show() },
                        AccentInactive,
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth()
                    )
                } else {
                    BlueButton("Далее", {
                        if (isThisOnEmail(email.value)) {
                            Toast.makeText(context, "Вход", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(
                                context,
                                "Проверьте правильность почты",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }, Accent, modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth())
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Зарегистрироваться",
                    fontSize = 15.sp,
                    color = Accent,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("createProfile") })
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 60.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = "Или войдите с помощью",
                    fontSize = 15.sp,
                    color = Caption,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(15.dp))
                ButtonEnterWith(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(),
                    { Toast.makeText(context, "Вход через ВК", Toast.LENGTH_LONG).show() },
                    R.drawable.vk_logo,
                    "Войти с VK"
                )
                Spacer(modifier = Modifier.height(15.dp))
                ButtonEnterWith(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth(),
                    { Toast.makeText(context, "Вход через Яндекс", Toast.LENGTH_LONG).show() },
                    R.drawable.yandex_logo,
                    "Войти с Yandex"
                )
            }
        }
    }
}