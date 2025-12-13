package com.kenval.deskcopy.ui

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalUriHandler
import com.kenval.deskcopy.Storage
import com.kenval.deskcopy.ui.component.ScaffoldMainScreen
import org.koin.compose.koinInject

@Composable
fun DesktopHomeScreen() {

    val storage: Storage = koinInject()
    val viewState = storage.state.collectAsState()
    val message = viewState.value

    val uriHandler = LocalUriHandler.current

    LaunchedEffect(message) {
        if (message.isNotBlank()) {
            uriHandler.openUri(message)
        }
    }

    ScaffoldMainScreen {
        OutlinedTextField(
            value = message,
            onValueChange = {},
            readOnly = true
        )
    }

}