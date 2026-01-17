package com.kenval.deskcopy.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalUriHandler
import com.kenval.deskcopy.Storage
import com.kenval.deskcopy.extensions.validateUrl
import com.kenval.deskcopy.ui.component.CheckboxWithText
import com.kenval.deskcopy.ui.component.LargeTitleText
import com.kenval.deskcopy.ui.component.PrimaryTextField
import com.kenval.deskcopy.ui.component.ScaffoldMainScreen
import org.koin.compose.koinInject

@Composable
fun DesktopHomeScreen() {

    val storage: Storage = koinInject()
    val viewState = storage.state.collectAsState()
    val message = viewState.value
    val snackbarState = remember { SnackbarHostState() }

    var openLink by remember { mutableStateOf(true) }

    val uriHandler = LocalUriHandler.current

    LaunchedEffect(message) {
        message.validateUrl(openLink) { url ->
            uriHandler.openUri(url)
        }
    }

    ScaffoldMainScreen(
        snackbarState = snackbarState
    ) {
        LargeTitleText("DeskCopy")
        PrimaryTextField(
            value = message,
            onValueChange = {},
            readOnly = true
        )
        CheckboxWithText(
            checked = openLink,
            onCheckedChange = { openLink = !openLink },
            text = "Open link in browser"
        )
    }

}