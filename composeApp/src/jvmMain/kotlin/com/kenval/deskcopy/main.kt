package com.kenval.deskcopy

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kenval.deskcopy.di.initKoin
import io.ktor.http.HttpStatusCode
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moe.tlaster.precompose.ProvidePreComposeLocals
import org.koin.compose.koinInject

fun main() = application {

    initKoin()

    val storage: Storage = koinInject()

    CoroutineScope(Dispatchers.IO).launch {
        embeddedServer(Netty, port = 8080) {
            routing {
                get("/") {
                    call.respond("Server responded!")
                }
                post("/message") {
                    val message = call.receive<String>()
                    storage.updateMessage(message)
                    call.respond(HttpStatusCode.OK)
                }
            }
        }.start(wait = true)
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "DeskCopy",
    ) {
        ProvidePreComposeLocals {
            App()
        }
    }
}