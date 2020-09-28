package net.alexandroid.samplesapp.ui

import androidx.lifecycle.LiveData
import net.alexandroid.samplesapp.R
import net.alexandroid.samplesapp.utils.BaseViewModel
import net.alexandroid.samplesapp.utils.SingleLiveEvent

class NavigationViewModel : BaseViewModel() {

    private var navEvent = SingleLiveEvent<Int>()
    fun getNavEvent(): LiveData<Int> = navEvent

    fun onBtnDataStoreClick() {
        navEvent.value = R.id.action_mainFragment_to_dataStoreFragment
    }
}