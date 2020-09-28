package net.alexandroid.samplesapp.repo

import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreRepo(private val dataStore: DataStore<Preferences>) {
    companion object {
        private val KEY = preferencesKey<String>("test")
    }

    val getText: Flow<String> = dataStore.data
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


    suspend fun saveText(text: String) {
        dataStore.edit { preferences ->
            preferences[KEY] = text
        }
    }
}