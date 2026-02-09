package com.kenval.deskcopy.data.source.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import io.ktor.websocket.send

class MessageRemoteSourceImpl(
    private val client: HttpClient
) : MessageRemoteSource {
    override suspend fun sendMessage(message: String, ipAddress: String) {
        client.post {
            url {
                protocol = URLProtocol.HTTP
                host = "/$ipAddress:8080/"
                path("message")
                setBody(message)
            }
        }
    }

    override suspend fun subscribeToMessages(ipAddress: String) {
        client.webSocket(
            method = HttpMethod.Get,
            host = "/$ipAddress:8080/",
            path = "message-two-way"
        ) {
            send("Subscribed to desktop!")
            for (frame in incoming) {
                frame as? Frame.Text ?: continue
                println("Received: ${frame.readText()}")
            }
        }
    }
}