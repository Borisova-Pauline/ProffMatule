package com.tomli.proffmatule.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.InputBG
import com.tomli.proffmatule.ui.theme.InputStroke

@Composable
fun PasswordInput(
    valueO: String,
    onChangeVal: (String) -> Unit,
    textPlaceHolder: String,
    picNotShow: Int,
    picShow: Int
) {
    val hidePassword = remember { mutableStateOf(true) }
    OutlinedTextField(
        value = valueO, onValueChange = onChangeVal,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        trailingIcon = {
            Image(painter = if (hidePassword.value) painterResource(picNotShow) else painterResource(
                picShow
            ),
                contentDescription = null,
                modifier = Modifier
                    .padding(15.dp)
                    .size(20.dp)
                    .clickable { hidePassword.value = !hidePassword.value })
        },
        placeholder = { Text(text = textPlaceHolder, color = Color(0xffabacb1)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Accent, unfocusedBorderColor = InputStroke,
            cursorColor = Accent,
            unfocusedContainerColor = InputBG, focusedContainerColor = InputBG
        ), visualTransformation = if (hidePassword.value) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    )
}