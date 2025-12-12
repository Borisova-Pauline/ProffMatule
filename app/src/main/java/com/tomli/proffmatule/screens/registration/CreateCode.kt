package com.tomli.proffmatule.screens.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tomli.proffmatule.R
import com.tomli.proffmatule.components.DotCode
import com.tomli.proffmatule.components.NumberInCircle
import com.tomli.proffmatule.ui.theme.Caption

@Composable
fun CreateCode(navController: NavController) {
    val scrollable = rememberScrollState()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .background(Color.White)
            .fillMaxSize().verticalScroll(scrollable)) {
            val code = remember { mutableStateOf("") }
            Column(
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .padding(top = 144.dp - innerPadding.calculateTopPadding()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Создайте пароль",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Для защиты ваших персональных данных",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = Caption,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 138.dp)
                    .fillMaxWidth()
                    .padding(top = (264.dp - innerPadding.calculateTopPadding()))
                    .height(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                val density = LocalDensity.current
                val radius = with(density) { 8.dp.toPx() }
                val stroke = 1
                DotCode(radius, stroke, 1, code.value.length)
                Spacer(modifier = Modifier.width(28.dp))
                DotCode(radius, stroke, 2, code.value.length)
                Spacer(modifier = Modifier.width(28.dp))
                DotCode(radius, stroke, 3, code.value.length)
                Spacer(modifier = Modifier.width(28.dp))
                DotCode(radius, stroke, 4, code.value.length)
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 43.dp)
                    .padding(top = (340.dp - innerPadding.calculateTopPadding()))
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    NumberInCircle(80, "1", { code.value = CodeAdder(code.value, 4, "1") })
                    Spacer(modifier = Modifier.width(24.dp))
                    NumberInCircle(80, "2", { code.value = CodeAdder(code.value, 4, "2") })
                    Spacer(modifier = Modifier.width(24.dp))
                    NumberInCircle(80, "3", { code.value = CodeAdder(code.value, 4, "3") })
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    NumberInCircle(80, "4", { code.value = CodeAdder(code.value, 4, "4") })
                    Spacer(modifier = Modifier.width(24.dp))
                    NumberInCircle(80, "5", { code.value = CodeAdder(code.value, 4, "5") })
                    Spacer(modifier = Modifier.width(24.dp))
                    NumberInCircle(80, "6", { code.value = CodeAdder(code.value, 4, "6") })
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    NumberInCircle(80, "7", { code.value = CodeAdder(code.value, 4, "7") })
                    Spacer(modifier = Modifier.width(24.dp))
                    NumberInCircle(80, "8", { code.value = CodeAdder(code.value, 4, "8") })
                    Spacer(modifier = Modifier.width(24.dp))
                    NumberInCircle(80, "9", { code.value = CodeAdder(code.value, 4, "9") })
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.size(80.dp))
                    Spacer(modifier = Modifier.width(24.dp))
                    NumberInCircle(80, "0", { code.value = CodeAdder(code.value, 4, "0") })
                    Spacer(modifier = Modifier.width(24.dp))
                    Image(painter = painterResource(R.drawable.delicion), contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(20.dp)
                            .clickable { code.value = code.value.dropLast(1) })
                }
            }
        }
    }
}