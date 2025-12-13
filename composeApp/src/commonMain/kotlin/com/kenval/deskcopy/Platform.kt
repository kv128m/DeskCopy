package com.kenval.deskcopy

sealed class Platform {

    data object Android : Platform()

    data object Desktop : Platform()

    data object IOS : Platform()

}

expect fun getPlatform(): Platform