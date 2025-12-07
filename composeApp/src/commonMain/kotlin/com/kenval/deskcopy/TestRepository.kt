package com.kenval.deskcopy

import DeskCopy.composeApp.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol

class TestRepository(
    private val api: HttpClient
) {
    suspend fun getResponse(): String {
        return api.get {
            url {
                protocol = URLProtocol.HTTP
                host = BuildConfig.BASE_URL
            }
        }.body()
    }
}

