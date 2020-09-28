package net.alexandroid.samplesapp.ui.datastore

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.alexandroid.samplesapp.repo.DataStoreRepo
import net.alexandroid.samplesapp.utils.BaseViewModel

class DataStoreViewModel(private val dataStoreRepo: DataStoreRepo) : BaseViewModel() {
    fun getTextFlow() = dataStoreRepo.getText

    fun onBtnSaveClick(text: String) = viewModelScope.launch {
        dataStoreRepo.saveText(text)
    }
}