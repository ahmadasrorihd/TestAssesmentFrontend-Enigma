package com.ahmadasrori.testassesmentfrontend_enigma

import android.app.Application
import com.ahmadasrori.testassesmentfrontend_enigma.di.dataModule
import com.ahmadasrori.testassesmentfrontend_enigma.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppController : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppController)
            modules(dataModule)
            modules(viewModelModule)
        }
    }


}