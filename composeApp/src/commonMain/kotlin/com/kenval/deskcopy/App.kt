package com.kenval.deskcopy

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kenval.deskcopy.theme.DeskCopyTheme
import com.kenval.deskcopy.ui.DesktopHomeScreen
import com.kenval.deskcopy.ui.MobileHomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    DeskCopyTheme {
        NavHost(
            navController = navController,
            startDestination = "/home"
        ) {
            composable("/home") {
                if (getPlatform() == Platform.Desktop) {
                    DesktopHomeScreen()
                } else {
                    MobileHomeScreen()
                }
            }
        }
    }
}