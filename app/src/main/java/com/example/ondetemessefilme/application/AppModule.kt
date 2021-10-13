package com.example.ondetemessefilme.application

import com.example.ondetemessefilme.ui.home.HomeRepository
import com.example.ondetemessefilme.ui.home.HomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    factory { HomeRepository(get()) }
    viewModel { HomeViewModel(get()) }
}