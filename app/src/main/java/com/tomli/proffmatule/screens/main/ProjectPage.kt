package com.tomli.proffmatule.screens.main

import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.tomli.proffmatule.R
import com.tomli.proffmatule.screens.registration.containsScreenName
import com.tomli.proffmatule.screens.registration.enumContains
import com.tomli.proffmatule.screens.registration.getCategory
import com.tomli.proffmatule.screens.registration.isDateRealDate
import com.tomli.proffmatule.ui.theme.Description
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import com.tomli.uikit.Accent
import com.tomli.uikit.buttons.BlueButton
import com.tomli.uikit.cards.MenuCategories
import com.tomli.uikit.inputs.InputDropDown
import com.tomli.uikit.inputs.SimpleInput
import com.tomli.uikit.project.ProjectCard
import com.tomli.uikit.project.ProjectInfo
import com.tomli.uikit.project.ProjectType
import com.tomli.uikit.project.ToWhom
import com.tomli.uikit.theme.robotoFont
import com.tomli.uikit.theme.spProDisplayRegular

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProjectPage(navController: NavController) {
    val isCreating = remember { mutableStateOf(false) }
    val cardsProject = remember {
        mutableStateListOf(
            ProjectInfo(
                0,
                ProjectType.Type1,
                "Вещь1",
                "21.11.2025",
                "25.01.2026",
                ToWhom.Per1,
                "uri",
                MenuCategories.Woman,
                null
            )
        )
    }
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {
        if (isCreating.value) {
            val type = remember{ mutableStateOf("")}
            val nameProj = remember{ mutableStateOf("")}
            val dateStart = remember{ mutableStateOf("")}
            val dateFinish=remember{ mutableStateOf("")}
            val toWhom = remember{ mutableStateOf("")}
            val source =remember{ mutableStateOf("")}
            val category = remember{ mutableStateOf("")}
            val image = remember{ mutableStateOf<Uri?>(null)}
            Column(modifier=Modifier.verticalScroll(rememberScrollState())){
                Text(
                    text = "Создать проект",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = robotoFont,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 30.dp),
                    textAlign = TextAlign.Center
                )
                Text(text = "Тип", fontFamily = spProDisplayRegular,color = Description, fontSize = 14.sp)
                InputDropDown(type.value, {newVal -> type.value=newVal}, "Выберите тип", listOf(ProjectType.Type1.name, ProjectType.Type2.name))
                Spacer(modifier=Modifier.height(10.dp))
                Text(text = "Название проекта", fontFamily = spProDisplayRegular,color = Description, fontSize = 14.sp)
                SimpleInput(nameProj.value, {newName -> nameProj.value=newName}, "Введите имя")
                Spacer(modifier=Modifier.height(10.dp))
                Text(text = "Дата начала", fontFamily = spProDisplayRegular,color = Description, fontSize = 14.sp)
                SimpleInput(dateStart.value, {newVal -> dateStart.value=newVal}, "--.--.----")
                Spacer(modifier=Modifier.height(10.dp))
                Text(text = "Дата Окончания", fontFamily = spProDisplayRegular,color = Description, fontSize = 14.sp)
                SimpleInput(dateFinish.value, {newVal -> dateFinish.value=newVal}, "--.--.----")
                Spacer(modifier=Modifier.height(10.dp))
                Text(text = "Кому", fontFamily = spProDisplayRegular,color = Description, fontSize = 14.sp)
                InputDropDown(toWhom.value, {newVal -> toWhom.value=newVal}, "Выберите кому", listOf(ToWhom.Per1.name, ToWhom.Per2.name))
                Spacer(modifier=Modifier.height(10.dp))
                Text(text = "Источник описания", fontFamily = spProDisplayRegular,color = Description, fontSize = 14.sp)
                SimpleInput(source.value, {newVal -> source.value=newVal}, "example.com")
                Spacer(modifier=Modifier.height(10.dp))
                Text(text = "Категория", fontFamily = spProDisplayRegular,color = Description, fontSize = 14.sp)
                InputDropDown(category.value, {newVal -> category.value=newVal}, "Выберите категорию",
                    listOf(MenuCategories.All.screenName, MenuCategories.Woman.screenName, MenuCategories.Man.screenName, MenuCategories.Kids.screenName, MenuCategories.Accessories.screenName))
                Spacer(modifier=Modifier.height(10.dp))
                Box(modifier=Modifier.align(Alignment.CenterHorizontally).size(200.dp)){
                    if(image.value==null){
                        Image(painter = painterResource(com.tomli.uikit.R.drawable.select_image), contentDescription = null, modifier = Modifier.fillMaxSize())
                    }else{
                        AsyncImage(model=image.value, contentDescription = null, modifier = Modifier.fillMaxSize())
                    }
                }
                Spacer(modifier=Modifier.height(30.dp))
                BlueButton("Подтвердить", {
                    if(nameProj.value!="" && source.value!="" && dateStart.value!="" && dateFinish.value!="" && toWhom.value!="" && category.value!="" && type.value!=""){
                        if(isDateRealDate(dateStart.value) && isDateRealDate(dateFinish.value, true)){
                            if(enumContains<ProjectType>(type.value) && enumContains<ToWhom>(toWhom.value) && containsScreenName(category.value)){
                                cardsProject.add(ProjectInfo(cardsProject.size, ProjectType.valueOf(type.value), nameProj.value, dateStart.value, dateFinish.value, ToWhom.valueOf(toWhom.value),
                                    source.value, getCategory(category.value), image.value))
                                isCreating.value=false
                            }else{
                                Toast.makeText(context, "Выберите варианты из списков", Toast.LENGTH_LONG).show()
                            }
                        }else{
                            Toast.makeText(context, "Даты не настоящие", Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(context, "Не все поля заполнены", Toast.LENGTH_LONG).show()
                    }
                }, Accent, modifier = Modifier.fillMaxWidth().height(56.dp))
            }
        } else {
            Box(modifier = Modifier.padding(top = 20.dp, bottom = 30.dp)) {
                Text(
                    text = "Проекты",
                    fontFamily = robotoFont,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Image(
                    painter = painterResource(com.tomli.uikit.R.drawable.plus),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(20.dp).clickable { isCreating.value=true }
                )
            }
            LazyColumn {
                items(items = cardsProject, key = { it.id }) { item ->
                    Box(modifier = Modifier
                        .wrapContentSize()
                        .padding(vertical = 5.dp)) {
                        ProjectCard(item)
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProffMatuleTheme {
        MainScreen(rememberNavController())
    }
}