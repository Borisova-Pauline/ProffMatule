package com.tomli.proffmatule.screens.main.tabbarpages.profilescreen

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tomli.proffmatule.R
import com.tomli.proffmatule.ui.theme.Caption
import com.tomli.proffmatule.ui.theme.ErrorColor
import com.tomli.uikit.theme.spProDisplayRegular

@Composable
fun ProfileScreen(navController: NavController) {
    val userName = remember { mutableStateOf("UserName") }
    val email = remember { mutableStateOf("example@gmail.com") }
    val isChecked = remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(Modifier.padding(horizontal = 20.dp)) {
        Column(modifier = Modifier.padding(top = 32.dp)) {
            Text(text = "${userName.value}", fontSize = 24.sp,fontFamily= spProDisplayRegular, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(5.dp))
            Text(text = "${email.value}", fontSize = 16.sp,fontFamily= spProDisplayRegular, color = Caption)
        }
        Spacer(Modifier.height(15.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.height(64.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.order),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .size(32.dp)
                )
                Text(text = "Мои заказы", fontSize = 17.sp,fontFamily= spProDisplayRegular, fontWeight = FontWeight.Bold)
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .height(64.dp)
                        .align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.settings),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .size(32.dp)
                    )
                    Text(text = "Уведомления",fontFamily= spProDisplayRegular, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                }
                Image(painter = painterResource(if (isChecked.value) R.drawable.switch_on else R.drawable.switch_off),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable {
                            isChecked.value = !isChecked.value
                            Toast.makeText(
                                context,
                                if (isChecked.value) "Уведомления включены" else "Уведомления выключены",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        .size(50.dp)
                )
            }
        }
        Box(modifier = Modifier.fillMaxSize(1f), contentAlignment = Alignment.Center) {
            Column {
                Text(text = "Политика конфиденциальности",
                    color = Caption, fontFamily= spProDisplayRegular,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Toast.makeText(
                                context,
                                "Переход на политику конфиденциальности",
                                Toast.LENGTH_LONG
                            ).show()
                        })
                Spacer(Modifier.height(24.dp))
                Text(text = "Пользовательское соглашение",
                    color = Caption,fontFamily= spProDisplayRegular,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Toast.makeText(
                                context,
                                "Переход на пользователькое соглашение",
                                Toast.LENGTH_LONG
                            ).show()
                        })
                Spacer(Modifier.height(24.dp))
                Text(text = "Выход",
                    color = ErrorColor,fontFamily= spProDisplayRegular,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("enterIfRegistrated")
                        })
            }
        }
    }
}