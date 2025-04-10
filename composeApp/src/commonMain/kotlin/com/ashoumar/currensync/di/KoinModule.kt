package com.ashoumar.currensync.di

import com.ashoumar.currensync.data.local.PreferencesRepoImpl
import com.ashoumar.currensync.data.remote.api.CurrencyApiServiceImpl
import com.ashoumar.currensync.domain.CurrencyApiService
import com.ashoumar.currensync.domain.PreferencesRepository
import com.russhwolf.settings.Settings
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module{
    single { Settings() }
    single<PreferencesRepository> { PreferencesRepoImpl(settings = get()) }
    single<CurrencyApiService> { CurrencyApiServiceImpl(preferences = get()) }
}

fun initializeKoin(){
    startKoin{
        modules(appModule)
    }
}