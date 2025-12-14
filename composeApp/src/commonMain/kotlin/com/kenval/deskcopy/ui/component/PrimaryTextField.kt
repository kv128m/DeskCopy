package com.kenval.deskcopy.ui.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.kenval.deskcopy.theme.mainFont
import com.kenval.deskcopy.theme.primaryTextFieldColors

@Composable
fun PrimaryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    readOnly: Boolean = false,
    placeholder: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        readOnly = readOnly,
        colors = primaryTextFieldColors(),
        textStyle = TextStyle(
            fontFamily = mainFont()
        ),
        placeholder = placeholder
    )
}