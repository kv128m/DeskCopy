package com.kenval.deskcopy.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.kenval.deskcopy.theme.cyberDemoFont
import com.kenval.deskcopy.theme.primaryButtonColors
import deskcopy.composeapp.generated.resources.CyberformDemo
import deskcopy.composeapp.generated.resources.DisposableDroidBB
import deskcopy.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = primaryButtonColors(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text, fontFamily = cyberDemoFont())
    }
}