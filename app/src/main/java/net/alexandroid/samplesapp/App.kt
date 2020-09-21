package net.alexandroid.samplesapp

import android.app.Application
import net.alexandroid.samplesapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}