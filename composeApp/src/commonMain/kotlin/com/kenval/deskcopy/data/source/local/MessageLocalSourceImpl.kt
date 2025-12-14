package com.kenval.deskcopy.data.source.local

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get

class MessageLocalSourceImpl(
    private val settings: Settings
) : MessageLocalSource {
    override fun getIpAddress() = settings.get<String>(IP_ADDRESS_KEY)

    override fun saveIpAddress(value: String) {
        settings.putString(IP_ADDRESS_KEY, value)
    }

    companion object {
        const val IP_ADDRESS_KEY = "ip_address"
    }
}