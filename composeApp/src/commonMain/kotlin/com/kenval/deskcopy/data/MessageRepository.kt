package com.kenval.deskcopy.data

import com.kenval.deskcopy.data.source.local.MessageLocalSource
import com.kenval.deskcopy.data.source.remote.MessageRemoteSource

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

    suspend fun subscribeToMessages() {
        val ipAddress = localSource.getIpAddress()
        ipAddress?.let {
            remoteSource.subscribeToMessages(ipAddress)
        }
    }

    fun saveIpAddress(ipAddress: String) {
        localSource.saveIpAddress(ipAddress)
    }

    fun getIpAddress(): String? {
        return localSource.getIpAddress()
    }
}