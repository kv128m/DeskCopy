package com.kenval.deskcopy.data

import com.kenval.deskcopy.data.source.local.MessageLocalSource
import com.kenval.deskcopy.data.source.remote.MessageRemoteSource
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path

class MessageRepository(
    private val localSource: MessageLocalSource,
    private val remoteSource: MessageRemoteSource
) {
    suspend fun sendMessage(message: String) {
        val ipAddress = localSource.getIpAddress()
        ipAddress?.let {
            remoteSource.sendMessage(message, ipAddress)
        }
    }

    fun saveIpAddress(ipAddress: String) {
        localSource.saveIpAddress(ipAddress)
    }
}