package net.alexandroid.samplesapp.repo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import net.alexandroid.samplesapp.network.Fail
import net.alexandroid.samplesapp.network.Success
import net.alexandroid.samplesapp.network.retryIO
import net.alexandroid.samplesapp.network.services.TmdbApiService

class MovieRepo(private val tmdbApiService: TmdbApiService) {

    fun getMovieTitle() = flow {
        delay(1000)
        emit("We will show here a title of a movie")
        delay(1000)

        val result = retryIO(desc = "Get movies") {
            tmdbApiService.getMovies()
        }
        when (result) {
            is Success -> emit(result.data.results[0].title)
            is Fail -> emit(result.e.message ?: "Failed")
        }
    }

}