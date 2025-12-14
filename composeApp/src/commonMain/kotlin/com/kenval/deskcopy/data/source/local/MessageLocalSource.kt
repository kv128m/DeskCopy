package com.kenval.deskcopy.data.source.local

interface MessageLocalSource {
    fun getIpAddress(): String?
    fun saveIpAddress(value: String)
}