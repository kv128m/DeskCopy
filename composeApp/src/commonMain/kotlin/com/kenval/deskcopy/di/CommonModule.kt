package com.kenval.deskcopy.di

import com.kenval.deskcopy.Storage
import com.kenval.deskcopy.data.MessageRepository
import com.kenval.deskcopy.data.source.local.MessageLocalSource
import com.kenval.deskcopy.data.source.local.MessageLocalSourceImpl
import com.kenval.deskcopy.data.source.remote.MessageRemoteSource
import com.kenval.deskcopy.data.source.remote.MessageRemoteSourceImpl
import com.kenval.deskcopy.ui.presentation.HomeViewModel
import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val commonModule = module {
    singleOf(::MessageRepository)
    singleOf(::Storage)
    singleOf(::MessageLocalSourceImpl) bind MessageLocalSource::class
    singleOf(::MessageRemoteSourceImpl) bind MessageRemoteSource::class
    singleOf(::Settings)
    factoryOf(::HomeViewModel)

}