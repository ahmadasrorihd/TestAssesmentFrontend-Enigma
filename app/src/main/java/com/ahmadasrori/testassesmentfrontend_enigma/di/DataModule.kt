package com.ahmadasrori.testassesmentfrontend_enigma.di

import com.ahmadasrori.testassesmentfrontend_enigma.data.Repository
import com.ahmadasrori.testassesmentfrontend_enigma.remote.Api
import com.ahmadasrori.testassesmentfrontend_enigma.remote.RetrofitClient
import org.koin.dsl.module

val dataModule = module {
    single {
        RetrofitClient.instance
    }
    factory {
        Repository(get<Api>())
    }
}