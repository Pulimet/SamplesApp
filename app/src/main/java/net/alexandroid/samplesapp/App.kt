package net.alexandroid.samplesapp

import android.app.Application
import net.alexandroid.samplesapp.di.appModule
import net.alexandroid.utils.mylogkt.MyLogKt
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setLogger()
        initKoin()
    }

    private fun setLogger() {
        MyLogKt.isLogsShown = BuildConfig.DEBUG
        MyLogKt.tag = "@@@"
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}