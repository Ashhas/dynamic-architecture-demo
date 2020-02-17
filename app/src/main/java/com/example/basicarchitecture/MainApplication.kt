package com.example.basicarchitecture

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Launch Koin Container
        startKoin {
            androidContext(applicationContext)
        }
    }
}