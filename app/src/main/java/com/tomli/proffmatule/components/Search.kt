package com.tomli.proffmatule.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.proffmatule.R
import com.tomli.proffmatule.ui.theme.Accent
import com.tomli.proffmatule.ui.theme.Caption
import com.tomli.proffmatule.ui.theme.InputBG
import com.tomli.proffmatule.ui.theme.InputStroke

@Composable
fun Search(text: String, onValChange: (newText: String) -> Unit, modifier: Modifier) {
    val focusManager = LocalFocusManager.current
    val isFocused = remember { mutableStateOf(false) }
    OutlinedTextField(
        value = text,
        onValueChange = onValChange,
        modifier = modifier.onFocusChanged { focusState -> isFocused.value = focusState.isFocused },
        placeholder = { Text(text = "Искать  описания", color = Caption, fontSize = 16.sp) },
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.search),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Accent, unfocusedBorderColor = InputStroke,
            cursorColor = Accent,
            unfocusedContainerColor = InputBG, focusedContainerColor = InputBG
        ),
        shape = RoundedCornerShape(10.dp),
        trailingIcon = {
            if (isFocused.value) {
                Image(
                    painter = painterResource(R.drawable.exit_sign),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { focusManager.clearFocus() })
            }
        },
        singleLine = true
    )
}