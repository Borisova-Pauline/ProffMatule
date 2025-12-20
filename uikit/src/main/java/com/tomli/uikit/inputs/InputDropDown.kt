package com.tomli.uikit.inputs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.Accent
import com.tomli.uikit.InputBG
import com.tomli.uikit.InputIcon
import com.tomli.uikit.InputStroke
import com.tomli.uikit.R
import com.tomli.uikit.theme.robotoFlexFont

@Composable
fun InputDropDown(
    valueO: String,
    onChangeVal: (String) -> Unit,
    textPlaceHolder: String,
    items: List<String>
) {
    val drop = remember { mutableStateOf(false) }
    Box(modifier = Modifier.wrapContentSize()) {
        OutlinedTextField(
            value = valueO, onValueChange = onChangeVal,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                Image(painter = painterResource(R.drawable.arrow_down),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(10.dp)
                        .clickable { drop.value = !drop.value })
            }, textStyle = TextStyle(fontFamily = robotoFlexFont, fontSize = 16.sp),
            placeholder = { Text(text = textPlaceHolder,fontFamily = robotoFlexFont, color = InputIcon) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Accent, unfocusedBorderColor = InputStroke,
                cursorColor = Accent,
                unfocusedContainerColor = InputBG, focusedContainerColor = InputBG
            )
        )
        DropdownMenu(expanded = drop.value, onDismissRequest = { drop.value = false }) {
            items.forEach { item ->
                DropdownMenuItem(text = { Text(item) },
                    onClick = { onChangeVal(item); drop.value = false })
            }
        }
    }
}