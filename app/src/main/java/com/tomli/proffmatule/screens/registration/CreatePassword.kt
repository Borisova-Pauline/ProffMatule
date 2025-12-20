package com.tomli.proffmatule.screens.registration

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tomli.proffmatule.R
import com.tomli.uikit.buttons.BlueButton
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.AccentInactive
import com.tomli.proffmatule.ui.theme.Description
import com.tomli.uikit.inputs.PasswordInput
import com.tomli.uikit.theme.spProDisplayRegular

@Composable
fun CreatePassword(navController: NavController) {
    val context = LocalContext.current
    val password = remember { mutableStateOf("") }
    val repeatPassword = remember { mutableStateOf("") }
    val scrollable = rememberScrollState()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .background(Color.White)
            .fillMaxSize().verticalScroll(scrollable)) {
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
                    Text(text = "Создание пароля", fontSize = 24.sp, fontFamily = spProDisplayRegular, fontWeight = FontWeight.Bold)
                }
                Text(text = "Введите новый пароль", fontSize = 15.sp, fontFamily = spProDisplayRegular)
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 268.dp - innerPadding.calculateTopPadding())
            ) {
                Text(text = "Новый Пароль", color = Description,fontFamily = spProDisplayRegular, fontSize = 14.sp)
                PasswordInput(
                    password.value,
                    { newText -> password.value = newText },
                    "",
                    R.drawable.hide_password,
                    R.drawable.show_password
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Повторите пароль", fontFamily = spProDisplayRegular,color = Description, fontSize = 14.sp)
                PasswordInput(
                    repeatPassword.value,
                    { newText -> repeatPassword.value = newText },
                    "",
                    R.drawable.hide_password,
                    R.drawable.show_password
                )
                Spacer(modifier = Modifier.height(15.dp))
                if (repeatPassword.value == "" || password.value == "") {
                    BlueButton(
                        "Сохранить",
                        { Toast.makeText(context, "Вы не ввели данные", Toast.LENGTH_LONG).show() },
                        AccentInactive,
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth()
                    )
                } else {
                    BlueButton("Сохранить", {
                        if (isThisOnRegexPassword(password.value)) {
                            if (password.value == repeatPassword.value) {
                                navController.navigate("createCode")
                            } else {
                                Toast.makeText(
                                    context,
                                    "Пароль не совпадает с повторением пароля",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "Пароль не достаточно надёжный",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }, Accent, modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth())
                }
            }
        }
    }
}