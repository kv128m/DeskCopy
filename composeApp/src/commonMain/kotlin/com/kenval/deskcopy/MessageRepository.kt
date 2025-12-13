package com.kenval.deskcopy

import DeskCopy.composeApp.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path

class MessageRepository(
    private val api: HttpClient
) {
    suspend fun sendMessage(message: String) {
        api.post {
            url {
                protocol = URLProtocol.HTTP
                host = BuildConfig.BASE_URL
                path("message")
                setBody(message)
            }
        }
    }
}

