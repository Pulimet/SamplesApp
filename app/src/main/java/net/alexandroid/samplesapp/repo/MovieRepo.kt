package net.alexandroid.samplesapp.repo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import net.alexandroid.samplesapp.network.services.TmdbApiService

class MovieRepo(private val tmdbApiService: TmdbApiService) {

    fun getMovieTitle() = flow {
        delay(1000)
        emit("We will show here a title of a movie")
        delay(1000)
        emit(tmdbApiService.getMovies().results[0].title)
    }

}