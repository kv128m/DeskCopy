package com.kenval.deskcopy.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kenval.deskcopy.theme.AppStyle
import com.kenval.deskcopy.ui.component.LargeTitleText
import com.kenval.deskcopy.ui.component.PrimaryButton
import com.kenval.deskcopy.ui.component.PrimaryText
import com.kenval.deskcopy.ui.component.PrimaryTextField
import com.kenval.deskcopy.ui.component.ScaffoldMainScreen
import com.kenval.deskcopy.ui.presentation.HomeViewModel
import deskcopy.composeapp.generated.resources.Res
import deskcopy.composeapp.generated.resources.ic_settings
import moe.tlaster.precompose.koin.koinViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun MobileHomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val viewState = viewModel.state.collectAsState().value
    val snackbarState = remember { SnackbarHostState() }
    val statusMessage = viewState.statusMessage

    LaunchedEffect(Unit) {
        viewModel.onEntered()
    }

    LaunchedEffect(statusMessage) {
       statusMessage?.let { message ->
            snackbarState.showSnackbar(message)
        }
        viewModel.resetStatusMessage()
    }

    LaunchedEffect(Unit) {
        viewModel.subscribeToMessages()
    }

    ScaffoldMainScreen(
        snackbarState = snackbarState
    ) {
        LargeTitleText("DeskCopy")

        PrimaryTextField(
            value = viewState.message,
            onValueChange = { viewModel.onMessageChange(it) }
        )

        PrimaryButton(
            onClick = {
                if (viewState.message.isNotBlank()) {
                    viewModel.onMessageSendConfirm()
                }
            },
            text = "Send"
        )

        Spacer(modifier = Modifier.height(16.dp))

        IconButton(
            onClick = {
                viewModel.onSettingsClick()
            }
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_settings),
                contentDescription = null,
                tint = AppStyle.Colors.content
            )
        }

        AnimatedVisibility(viewState.settingsExpanded) {
            PrimaryTextField(
                value = viewState.ipAddress,
                onValueChange = { viewModel.onIpAddressChange(it) },
                placeholder = { PrimaryText("Set the local IP address") }
            )
        }

        AnimatedVisibility(viewState.settingsExpanded) {
            PrimaryButton(
                onClick = { viewModel.onIpAddressChangeConfirm() },
                text = "Confirm"
            )
        }

    }

}