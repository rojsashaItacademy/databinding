package ru.trinitydigital.databinfingvm

import android.app.Application
import org.koin.android.ext.android.startKoin
import ru.trinitydigital.databinfingvm.di.appModules

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}