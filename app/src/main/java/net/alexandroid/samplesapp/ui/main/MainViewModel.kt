package net.alexandroid.samplesapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.onStart
import net.alexandroid.samplesapp.repo.MovieRepo

@ExperimentalCoroutinesApi
class MainViewModel(private val movieRepo: MovieRepo) : ViewModel() {

    fun getMovieTitle(): LiveData<String> = movieRepo.getMovieTitle()
        .onStart { emit("Loading...") }
        .asLiveData()

}