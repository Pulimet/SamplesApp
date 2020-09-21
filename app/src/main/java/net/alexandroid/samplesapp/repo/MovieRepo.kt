package net.alexandroid.samplesapp.repo

import androidx.lifecycle.MutableLiveData

class MovieRepo {

    fun getMovieTitle() = MutableLiveData("We will show here a title of a movie")

}