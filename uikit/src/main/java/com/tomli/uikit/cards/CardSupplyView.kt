package com.tomli.uikit.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.Accent
import com.tomli.uikit.Caption
import com.tomli.uikit.ColorDivider
import com.tomli.uikit.theme.robotoFont

@Composable
fun CardSupplyView(card: CardSupply, onAddClick: () -> Unit) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = ColorDivider,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
            .width(335.dp)
            .height(136.dp)
    ) {
        Text(
            text = card.name,
            fontWeight = FontWeight(500),
            fontSize = 16.sp,
            fontFamily = robotoFont
        )
        Row(modifier = Modifier.weight(1f)) {
            Column {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = card.category.screenName,
                    fontWeight = FontWeight(600),
                    color = Caption,
                    fontSize = 14.sp, fontFamily = robotoFont
                )
                Text(
                    text = "${card.price} ₽",
                    fontWeight = FontWeight(600),
                    fontSize = 17.sp,
                    fontFamily = robotoFont
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(modifier = Modifier.width(96.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                if (card.isAdded) {
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth(1f)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                            .clickable { onAddClick() }
                            .border(
                                width = 1.dp,
                                color = Accent,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Убрать",
                            color = Accent,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            fontFamily = robotoFont
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth(1f)
                            .background(color = Accent, shape = RoundedCornerShape(10.dp))
                            .clickable { onAddClick() }, contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Добавить",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(600),
                            fontFamily = robotoFont
                        )
                    }
                }
            }
        }
    }
}