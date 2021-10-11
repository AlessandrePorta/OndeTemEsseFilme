package com.example.ondetemessefilme.application

import com.example.ondetemessefilme.data.network.Endpoint
import com.example.ondetemessefilme.data.network.Repository
import com.example.ondetemessefilme.ui.home.HomeViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    factory { Repository(get()) }
    viewModel { HomeViewModel(get()) }
}

val netWorkModule = module {
    factory {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    factory { get<Retrofit>().create(Endpoint::class.java) }
}