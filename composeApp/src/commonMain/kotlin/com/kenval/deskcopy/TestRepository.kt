package com.kenval.deskcopy

import DeskCopy.composeApp.BuildConfig
import androidx.compose.runtime.MutableState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.internal.ChannelFlow

class TestRepository(
    private val api: HttpClient
) {
    @OptIn(InternalCoroutinesApi::class)
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

    suspend fun getResponse(): String {
        return api.get {
            url {
                protocol = URLProtocol.HTTP
                host = BuildConfig.BASE_URL
            }
        }.body()
    }
}

