package com.ahmadasrori.testassesmentfrontend_enigma.di

import com.ahmadasrori.testassesmentfrontend_enigma.data.Repository
import com.ahmadasrori.testassesmentfrontend_enigma.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get<Repository>())
    }
}