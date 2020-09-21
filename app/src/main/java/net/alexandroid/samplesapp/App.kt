package net.alexandroid.samplesapp

import android.app.Application
import net.alexandroid.samplesapp.di.KoinLogs
import net.alexandroid.samplesapp.di.appModule
import net.alexandroid.utils.mylogkt.MyLogKt
import net.alexandroid.utils.mylogkt.warn
import org.koin.android.ext.koin.androidContext
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
        warn("=== App created and logger is ready ===")
    }

    private fun initKoin() {
        startKoin {
            KoinLogs()
            androidContext(this@App)
            modules(appModule)
        }
    }
}