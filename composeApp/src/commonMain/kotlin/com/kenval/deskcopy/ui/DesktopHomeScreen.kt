package com.kenval.deskcopy.ui

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.kenval.deskcopy.Storage
import com.kenval.deskcopy.ui.component.ScaffoldMainScreen
import org.koin.compose.koinInject

@Composable
fun DesktopHomeScreen() {
    val storage: Storage = koinInject()
    val viewState = storage.state.collectAsState()

    ScaffoldMainScreen {
        OutlinedTextField(
            value = viewState.value,
            onValueChange = {},
            readOnly = true
        )
    }
}