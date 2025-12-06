package com.kenval.deskcopy

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path

class TestRepository(
    private val api: HttpClient
) {
    suspend fun getResponse(): String {
        return api.get {
            url {
                protocol = URLProtocol.HTTP
                host = "0.0.0.0"
                path("/")
            }
        }.body()
    }
}

