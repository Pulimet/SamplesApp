package net.alexandroid.samplesapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.alexandroid.samplesapp.di.KoinLogs
import net.alexandroid.samplesapp.di.appModule
import net.alexandroid.utils.mylogkt.MyLogKt
import net.alexandroid.utils.mylogkt.info
import net.alexandroid.utils.mylogkt.warn
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

class App : Application(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

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

    private fun initKoin() = launch {
        val koinInitTime = measureTimeMillis {
            startKoin {
                logger(KoinLogs())
                androidContext(this@App)
                modules(appModule)
            }
        }
        info("=== Koin init time: $koinInitTime ms ===")
    }
}