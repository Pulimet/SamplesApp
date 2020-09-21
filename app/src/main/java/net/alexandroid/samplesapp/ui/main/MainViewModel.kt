package net.alexandroid.samplesapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.alexandroid.samplesapp.repo.MovieRepo

class MainViewModel(private val movieRepo: MovieRepo) : ViewModel() {

    fun getMovieTitle(): LiveData<String> = movieRepo.getMovieTitle()

}