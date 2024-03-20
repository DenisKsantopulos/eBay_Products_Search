package com.example.onlinestore.app

import android.app.Application
import com.example.onlinestore.di.appModule
import com.example.onlinestore.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG) // how much to log errors
            //androidContext(this@App)

            modules(listOf(appModule, domainModule))
        }
    }
}