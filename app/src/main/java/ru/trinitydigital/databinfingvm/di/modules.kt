package ru.trinitydigital.databinfingvm.di

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import ru.trinitydigital.databinfingvm.ui.main.MainViewModel

val viewModelModule = module(override = true) {
    viewModel { MainViewModel() }
//
}

val appModules = listOf(viewModelModule)