package com.kenval.deskcopy

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kenval.deskcopy.di.initKoin
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import io.ktor.server.websocket.WebSockets
import io.ktor.server.websocket.webSocket
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import io.ktor.websocket.send
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import moe.tlaster.precompose.ProvidePreComposeLocals
import org.koin.compose.koinInject

fun main() = application {

    initKoin()

    val storage: Storage = koinInject()

    CoroutineScope(Dispatchers.IO).launch {
        embeddedServer(Netty, port = 8080) {
            install(WebSockets) {
                pingPeriodMillis = 20000L
                timeoutMillis = 20000L
                maxFrameSize = Long.MAX_VALUE
                masking = false
                contentConverter = KotlinxWebsocketSerializationConverter(Json)
            }

            routing {
                get("/") {
                    call.respond("Server responded!")
                }
                post("/message") {
                    val message = call.receive<String>()
                    storage.updateMessage(message)
                    call.respond(HttpStatusCode.OK)
                }
                webSocket("/message-two-way") {
                    for (frame in incoming) {
                        if (frame is Frame.Text) {
                            val receivedText = frame.readText()
                            send("Received text frame: $receivedText")
                        }
                    }
                }
            }
        }.start(wait = true)
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "DeskCopy"
    ) {
        ProvidePreComposeLocals {
            App()
        }
    }
}