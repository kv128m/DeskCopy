package com.kenval.deskcopy.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.kenval.deskcopy.MessageRepository
import com.kenval.deskcopy.ui.component.LargeTitleText
import com.kenval.deskcopy.ui.component.PrimaryButton
import com.kenval.deskcopy.ui.component.PrimaryTextField
import com.kenval.deskcopy.ui.component.ScaffoldMainScreen
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun MobileHomeScreen() {

    val messageRepo: MessageRepository = koinInject()
    var message by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    ScaffoldMainScreen {

        LargeTitleText("DeskCopy")

        PrimaryTextField(
            value = message,
            onValueChange = { message = it }
        )

        PrimaryButton(
            onClick = {
                coroutineScope.launch {
                    if (message.isNotBlank()) {
                        messageRepo.sendMessage(message)
                    }
                }
            },
            text = "Send"
        )

    }

}