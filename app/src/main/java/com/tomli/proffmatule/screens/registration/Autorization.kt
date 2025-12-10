package com.tomli.proffmatule.screens.registration

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tomli.proffmatule.ui.theme.ProffMatuleTheme


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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProffMatuleTheme {

    }
}