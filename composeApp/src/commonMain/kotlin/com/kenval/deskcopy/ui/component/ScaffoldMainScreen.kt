package com.kenval.deskcopy.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kenval.deskcopy.effects.snowfall.SnowOverlay
import com.kenval.deskcopy.theme.AppStyle
import com.kenval.deskcopy.theme.mainFont

@Composable
fun ScaffoldMainScreen(
    snackbarState: SnackbarHostState,
    content: @Composable () -> Unit
) {
    Scaffold(
        containerColor = AppStyle.Colors.background,
        contentColor = AppStyle.Colors.content,
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarState,
                snackbar = { snackbarData ->
                    Snackbar(
                        shape = RoundedCornerShape(12.dp),
                        containerColor = AppStyle.Colors.focusedBorder,
                        contentColor = AppStyle.Colors.content,
                        content = {
                            Text(
                                text = snackbarData.visuals.message,
                                style = TextStyle(
                                    fontFamily = mainFont(),
                                    fontSize = 18.sp
                                )
                            )
                        }
                    )
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            SnowOverlay()

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()
            }
        }
    }
}