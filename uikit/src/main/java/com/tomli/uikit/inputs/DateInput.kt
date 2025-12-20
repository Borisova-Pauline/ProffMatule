package com.tomli.uikit.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.Accent
import com.tomli.uikit.InputBG
import com.tomli.uikit.InputIcon
import com.tomli.uikit.InputStroke
import com.tomli.uikit.theme.robotoFlexFont

//simpleinput, но клавиатура даёт ввести только числа
@Composable
fun DateInput(valueO: String, onChangeVal: (String) -> Unit, textPlaceHolder: String) {
    OutlinedTextField(
        value = valueO, onValueChange = onChangeVal,
        modifier = Modifier.fillMaxWidth(), textStyle = TextStyle(fontFamily = robotoFlexFont, fontSize = 16.sp),
        shape = RoundedCornerShape(10.dp),
        placeholder = { Text(text = textPlaceHolder, fontFamily = robotoFlexFont, color = InputIcon) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Accent, unfocusedBorderColor = InputStroke,
            cursorColor = Accent,
            unfocusedContainerColor = InputBG, focusedContainerColor = InputBG
        ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}