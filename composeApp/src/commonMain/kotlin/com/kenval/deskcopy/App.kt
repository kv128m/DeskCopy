package com.kenval.deskcopy

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.kenval.deskcopy.theme.DeskCopyTheme
import com.kenval.deskcopy.ui.HomeScreen
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App(message: String = "") {
    PreComposeApp {
            val navigator = rememberNavigator()
            DeskCopyTheme {
                NavHost(
                    navigator = navigator,
                    initialRoute = "/home"
                ) {
                    scene("/home") {
                        HomeScreen()
                    }
                }
            }
    }
}