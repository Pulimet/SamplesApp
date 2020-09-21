package net.alexandroid.samplesapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.onStart
import net.alexandroid.samplesapp.repo.MovieRepo
import net.alexandroid.samplesapp.ui.BaseViewModel

@Suppress("EXPERIMENTAL_API_USAGE")
class MainViewModel(private val movieRepo: MovieRepo) : BaseViewModel() {

    fun getMovieTitle(): LiveData<String> = movieRepo.getMovieTitle()
        .onStart { emit("Loading...") }
        .asLiveData()

}