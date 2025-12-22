package com.tomli.uikit.project

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.Accent
import com.tomli.uikit.Caption
import com.tomli.uikit.ColorDivider
import com.tomli.uikit.theme.robotoFont
import com.tomli.uikit.theme.spProDisplayRegular
import java.time.Duration
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProjectCard(card: ProjectInfo) {
    val date: List<String> = card.dateStart.split('.')
    var startDate: LocalDate
    try {
        startDate = LocalDate.of(date[2].toInt(), date[1].toInt(), date[0].toInt())
    } catch (e: Exception) {
        startDate = LocalDate.of(2000, 1, 1)
    }
    val days = Duration.between(startDate.atStartOfDay(), LocalDate.now().atStartOfDay())
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .height(136.dp)
            .border(
                width = 1.dp,
                color = ColorDivider,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(15.dp)
    ) {
        Text(
            text = card.name,
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            fontFamily = spProDisplayRegular
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Прошло ${days.toDays()} дней",
                color = Caption,
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                fontFamily = spProDisplayRegular
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(96.dp)
                    .background(color = Accent, shape = RoundedCornerShape(10.dp))
                    .clickable { Toast.makeText(context, "Открытие", Toast.LENGTH_LONG).show() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Открыть",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = spProDisplayRegular
                )
            }
        }
    }
}