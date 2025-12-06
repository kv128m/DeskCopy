package com.kenval.deskcopy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kenval.deskcopy.theme.DeskCopyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.mp.KoinPlatformTools

@Composable
@Preview
fun App() {

    val testRepo by lazy { KoinPlatformTools.defaultContext().get().get<TestRepository>() }

    DeskCopyTheme {
        Scaffold { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                CoroutineScope(Dispatchers.IO).launch {
                    val result = testRepo.getResponse()
                    println(result)
                }
            }
        }
    }
}