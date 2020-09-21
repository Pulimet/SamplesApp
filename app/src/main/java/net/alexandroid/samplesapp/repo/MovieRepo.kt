package net.alexandroid.samplesapp.repo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MovieRepo {

    fun getMovieTitle() = flow {
        delay(1000)
        emit("We will show here a title of a movie")
    }

}