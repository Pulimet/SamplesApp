package net.alexandroid.samplesapp.ui.datastore

import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import net.alexandroid.samplesapp.utils.BaseViewModel
import java.io.IOException

class DataStoreViewModel(private val dataStore: DataStore<Preferences>) : BaseViewModel() {

    companion object {
        private val KEY = preferencesKey<String>("test")
    }

    val userPreferencesFlow: Flow<String> = dataStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[KEY] ?: ""
        }


    fun onBtnSaveClick(text: String) = viewModelScope.launch {
        dataStore.edit { preferences ->
            preferences[KEY] = text
        }
    }
}