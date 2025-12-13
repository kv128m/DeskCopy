package com.kenval.deskcopy.di

import com.kenval.deskcopy.Storage
import com.kenval.deskcopy.MessageRepository
import com.kenval.deskcopy.TestViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    singleOf(::MessageRepository)
    singleOf(::Storage)
    factory { TestViewModel() }
}