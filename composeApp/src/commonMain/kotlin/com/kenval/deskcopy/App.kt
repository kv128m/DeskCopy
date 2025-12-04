package com.kenval.deskcopy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kenval.deskcopy.theme.DeskCopyTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    DeskCopyTheme {
        Scaffold { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {

            }
        }
    }
}