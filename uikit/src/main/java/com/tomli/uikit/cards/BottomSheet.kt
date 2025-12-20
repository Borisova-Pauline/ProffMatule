package com.tomli.uikit.cards

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tomli.uikit.Accent
import com.tomli.uikit.Caption
import com.tomli.uikit.R
import com.tomli.uikit.buttons.BlueButton
import com.tomli.uikit.theme.robotoFlexFont
import com.tomli.uikit.theme.spProDisplayRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(card: CardSupply, onDismiss:()->Unit, sheetState: SheetState){
    val context = LocalContext.current
    ModalBottomSheet(onDismiss, sheetState=sheetState, containerColor = Color.White, modifier = Modifier.wrapContentHeight().fillMaxWidth(),
        dragHandle = null) {
        Column(modifier=Modifier.padding(horizontal = 20.dp, vertical = 24.dp)){
            Row(modifier=Modifier.fillMaxWidth()){
                Text(text=card.name, fontSize = 20.sp, fontWeight = FontWeight(600), modifier = Modifier.weight(1f), fontFamily = spProDisplayRegular)
                Image(painter= painterResource(R.drawable.close_round), contentDescription = null, modifier = Modifier.size(24.dp).clickable { onDismiss() })
            }
            Spacer(modifier=Modifier.height(20.dp))
            LazyColumn(modifier=Modifier.weight(1f, false)){
                items(card.description) { item ->
                    Column {
                        Text(
                            text = item.section,
                            color = Caption,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp,
                            fontFamily = spProDisplayRegular
                        )
                        Text(text = item.descr, fontSize = 15.sp, fontFamily = robotoFlexFont)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
            BlueButton("Добавить за ${card.price} ₽", {
                Toast.makeText(context, "Добавлено", Toast.LENGTH_LONG).show()
            }, Accent, Modifier.fillMaxWidth().height(56.dp))
        }
    }
}