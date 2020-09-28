package net.alexandroid.samplesapp.ui

import androidx.lifecycle.LiveData
import net.alexandroid.samplesapp.R
import net.alexandroid.samplesapp.utils.BaseViewModel
import net.alexandroid.samplesapp.utils.SingleLiveEvent
import net.alexandroid.utils.mylogkt.logD

class NavigationViewModel : BaseViewModel() {

    private var navEvent = SingleLiveEvent<Int>()
    fun getNavEvent(): LiveData<Int> = navEvent

    fun onBtnDataStoreClick() {
        navEvent.setValue(R.id.action_mainFragment_to_dataStoreFragment)
    }
}