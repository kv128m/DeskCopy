package com.kenval.deskcopy.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kenval.deskcopy.Storage
import com.kenval.deskcopy.TestRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun HomeScreen() {
    val testRepo: TestRepository = koinInject()

    var message by remember { mutableStateOf("") }
    val storage: Storage = koinInject()
    val viewState = storage.state.collectAsState()

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = message,
                    onValueChange = { message = it }
                )
                Button(
                    onClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            if (message.isNotBlank()) {
                                testRepo.sendMessage(message)
                            }
                        }
                    }
                ) {
                    Text("Send to server")
                }
                OutlinedTextField(
                    value = viewState.value,
                    onValueChange = {},
                    readOnly = true
                )
            }

        }
    }
}