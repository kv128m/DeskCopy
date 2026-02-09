package com.kenval.deskcopy.data.source.remote

interface MessageRemoteSource {
    suspend fun sendMessage(message: String, ipAddress: String)

    suspend fun subscribeToMessages(ipAddress: String)
}