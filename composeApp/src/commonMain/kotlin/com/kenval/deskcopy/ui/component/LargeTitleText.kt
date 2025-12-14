package com.kenval.deskcopy.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kenval.deskcopy.theme.AppStyle
import com.kenval.deskcopy.theme.mainFont
import deskcopy.composeapp.generated.resources.DisposableDroidBB
import deskcopy.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun LargeTitleText(
    text: String
) {
    Text(
        text = text,
        color = AppStyle.Colors.content,
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = mainFont()
    )
}