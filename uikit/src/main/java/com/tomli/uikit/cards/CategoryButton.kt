package com.tomli.uikit.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.Accent
import com.tomli.uikit.InputBG
import com.tomli.uikit.theme.robotoFlexFont

@Composable
fun CategoryButton(
    buttonText: String,
    onClick: () -> Unit,
    thisValue: MenuCategories,
    needValue: MenuCategories
) {
    Box(
        modifier = Modifier
            .background(
                color = if (thisValue == needValue) Accent else InputBG,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() }) {
        Text(
            text = buttonText,
            color = if (thisValue == needValue) Color.White else Color(0xff7e7e9a),
            fontSize = 15.sp,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp),
            fontWeight = FontWeight(500), fontFamily = robotoFlexFont
        )
    }
}