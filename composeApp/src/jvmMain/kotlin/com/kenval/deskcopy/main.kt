package com.kenval.deskcopy

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kenval.deskcopy.di.initKoin
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun main() = application {

    initKoin()

    CoroutineScope(Dispatchers.IO).launch {
        embeddedServer(Netty, port = 8080) {
            routing {
                get("/") {
                    call.respond("Server responded!")
                }
            }
        }.start(wait = true)
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "DeskCopy",
    ) {
        App()
    }
}