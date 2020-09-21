package net.alexandroid.samplesapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    private val movieTitle = MutableLiveData("We will show here a title of movie")
    fun getMovieTitle(): LiveData<String> = movieTitle
}