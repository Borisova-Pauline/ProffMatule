package com.tomli.proffmatule.screens.registration

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tomli.uikit.buttons.BlueButton
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.AccentInactive
import com.tomli.proffmatule.ui.theme.Caption
import com.tomli.uikit.inputs.DateInput
import com.tomli.uikit.inputs.InputDropDown
import com.tomli.uikit.inputs.SimpleInput
import com.tomli.uikit.theme.spProDisplayRegular

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreatingProfile(navController: NavController) {
    val context = LocalContext.current
    val name = remember { mutableStateOf("") }
    val fatherName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val birthDay = remember { mutableStateOf("") }
    val gender = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val scrollable = rememberScrollState()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .background(Color.White)
            .fillMaxSize().verticalScroll(scrollable)) {
            Text(
                text = "Создание Профиля",fontFamily = spProDisplayRegular, fontSize = 24.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 74.dp - innerPadding.calculateTopPadding())
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 146.dp - innerPadding.calculateTopPadding())
            ) {
                Text(
                    text = "Без профиля вы не сможете создавать проекты.",
                    fontSize = 14.sp,fontFamily = spProDisplayRegular,
                    color = Caption
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "В профиле будут храниться результаты проектов и ваши описания.",
                    fontSize = 14.sp,fontFamily = spProDisplayRegular,
                    color = Caption
                )
            }
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(top = 240.dp - innerPadding.calculateTopPadding())
            ) {
                SimpleInput(name.value, { newText -> name.value = newText }, "Имя")
                Spacer(modifier = Modifier.height(20.dp))
                SimpleInput(fatherName.value, { newText -> fatherName.value = newText }, "Отчество")
                Spacer(modifier = Modifier.height(20.dp))
                SimpleInput(lastName.value, { newText -> lastName.value = newText }, "Фамилия")
                Spacer(modifier = Modifier.height(20.dp))
                DateInput(
                    birthDay.value,
                    { newText -> birthDay.value = newText },
                    "День рождения"
                )
                Spacer(modifier = Modifier.height(20.dp))
                InputDropDown(
                    gender.value,
                    { newText -> gender.value = newText },
                    "Пол",
                    listOf("Мужской", "Женский")
                )
                Spacer(modifier = Modifier.height(20.dp))
                SimpleInput(email.value, { newText -> email.value = newText }, "Почта")
            }
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(top = 720.dp - innerPadding.calculateTopPadding())
                    .align(Alignment.BottomCenter)
            ) {
                if (name.value == "" || fatherName.value == "" || lastName.value == "" || birthDay.value == "" || gender.value == "" || email.value == "") {
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
                            if(isDateRealDate(birthDay.value)){
                                navController.navigate("CreatePassword")
                            }else{
                                Toast.makeText(
                                    context,
                                    "Дата должна быть написана \"--.--.----\"",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
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
            }
        }
    }
}