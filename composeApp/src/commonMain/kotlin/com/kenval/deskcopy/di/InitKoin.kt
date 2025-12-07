package com.kenval.deskcopy.di

import org.koin.compose.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

fun initKoin() {
    startKoin {
        modules(appModules)
    }
}