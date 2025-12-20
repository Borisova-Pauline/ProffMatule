package com.tomli.proffmatule.screens.registration

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme
import java.time.Year


fun CodeAdder(code: String, maxLength: Int, pressedVal: String): String {
    if (code.length >= maxLength) {
        return code
    } else {
        return code + pressedVal
    }
}

fun isThisOnRegexPassword(word: String): Boolean {
    return (word.matches(Regex(".{8,}"))) && (word.matches(Regex(".*[a-z]+.*"))) && (word.matches(
        Regex(".*[A-Z]+.*")
    )) && (word.matches(Regex(".*[0-9]+.*")))
}

fun isThisOnEmail(word: String): Boolean {
    return (word.matches(Regex("[a-z0-9]+@[a-z]+\\.[a-z]+")))
}

@RequiresApi(Build.VERSION_CODES.O)
fun isDateRealDate(date: String): Boolean{
    val listNums = date.split(".")
    if(listNums.size<3){
        return false
    }
    try{
        if(listNums[0].toInt()<=31 && listNums[1].toInt()<=12 && listNums[2].toInt()<= Year.now().value){
            return true
        }else{
            return false
        }
    }catch (e: Exception){
        e.printStackTrace()
        return false
    }
}