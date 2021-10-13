package com.example.ondetemessefilme.application

import android.app.Application
import com.example.ondetemessefilme.data.network.netWorkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(listOf(appModule, netWorkModule))
        }
    }

}