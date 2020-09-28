package net.alexandroid.samplesapp.utils

import androidx.lifecycle.ViewModel
import net.alexandroid.utils.mylogkt.logW

abstract class BaseViewModel : ViewModel() {
    init {
        logW("${javaClass.simpleName} - init")
    }

    override fun onCleared() {
        logW("${javaClass.simpleName} - onCleared")
    }
}