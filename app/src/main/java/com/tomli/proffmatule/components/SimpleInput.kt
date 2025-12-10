package com.tomli.proffmatule.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.InputBG
import com.tomli.proffmatule.ui.theme.InputIcon
import com.tomli.proffmatule.ui.theme.InputStroke

@Composable
fun SimpleInput(valueO: String, onChangeVal: (String) -> Unit, textPlaceHolder: String) {
    OutlinedTextField(
        value = valueO, onValueChange = onChangeVal,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        placeholder = { Text(text = textPlaceHolder, color = InputIcon) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Accent, unfocusedBorderColor = InputStroke,
            cursorColor = Accent,
            unfocusedContainerColor = InputBG, focusedContainerColor = InputBG
        )
    )
}