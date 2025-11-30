package com.kenval.deskcopy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform