package com.kenval.deskcopy.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.kenval.deskcopy.theme.cyberDemoFont
import com.kenval.deskcopy.theme.primaryButtonColors

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