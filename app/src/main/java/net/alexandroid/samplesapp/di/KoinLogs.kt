package net.alexandroid.samplesapp.di

import net.alexandroid.utils.mylogkt.logD
import net.alexandroid.utils.mylogkt.logE
import net.alexandroid.utils.mylogkt.logI
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE

class KoinLogs : Logger(level = Level.DEBUG) {
    override fun log(level: Level, msg: MESSAGE) {
        when (level) {
            Level.DEBUG -> logD(msg)
            Level.INFO ->  logI(msg)
            Level.ERROR -> logE(msg)
            Level.NONE -> logD(msg)
        }
    }
}