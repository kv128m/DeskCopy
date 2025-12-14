package com.kenval.deskcopy.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.kenval.deskcopy.theme.AppStyle
import com.kenval.deskcopy.theme.mainFont

@Composable
fun PrimaryText(
    text: String
) {
    Text(
        text = text,
        color = AppStyle.Colors.content,
        fontSize = 16.sp,
        fontFamily = mainFont()
    )
}