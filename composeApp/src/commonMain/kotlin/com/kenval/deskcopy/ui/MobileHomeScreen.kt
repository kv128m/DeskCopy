package com.kenval.deskcopy.ui

import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.kenval.deskcopy.TestRepository
import com.kenval.deskcopy.ui.component.ScaffoldMainScreen
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun MobileHomeScreen() {
    val testRepo: TestRepository = koinInject()

    var message by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    ScaffoldMainScreen {

        OutlinedTextField(
            value = message,
            onValueChange = { message = it }
        )

        Button(
            onClick = {
                coroutineScope.launch {
                    if (message.isNotBlank()) {
                        testRepo.sendMessage(message)
                    }
                }
            }
        ) {
            Text("Send to server")
        }
    }
}