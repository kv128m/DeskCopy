package com.kenval.deskcopy.data.source.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path

class MessageRemoteSourceImpl(
    private val api: HttpClient
) : MessageRemoteSource {
    override suspend fun sendMessage(message: String, ipAddress: String) {
        api.post {
            url {
                protocol = URLProtocol.HTTP
                host = "/$ipAddress:8080/"
                path("message")
                setBody(message)
            }
        }
    }
}