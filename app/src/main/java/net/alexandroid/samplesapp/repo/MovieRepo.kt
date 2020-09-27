package net.alexandroid.samplesapp.repo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import net.alexandroid.samplesapp.db.MovieDao
import net.alexandroid.samplesapp.network.Fail
import net.alexandroid.samplesapp.network.Success
import net.alexandroid.samplesapp.network.retryThis
import net.alexandroid.samplesapp.network.services.TmdbApiService

class MovieRepo(private val tmdbApiService: TmdbApiService, private val movieDao: MovieDao) {

    fun getMovieTitle() = flow {
        delay(1000)
        emit("Getting movies from DB")
        val moviesFromDb = movieDao.getMoviesChange().firstOrNull()
        delay(1000)
        emit("There is ${moviesFromDb?.size ?: 0} movies in DB")
        delay(1000)
        if (moviesFromDb != null && moviesFromDb.isNotEmpty()) {
            emit("Movie title from DB: ${moviesFromDb[0].title}")
            delay(2000)
        }
        emit("Getting movie title from network")
        delay(1000)

        val result = retryThis(desc = "Get movies") {
            tmdbApiService.getMovies()
        }

        when (result) {
            is Success -> {
                val title = result.data.results[0].title
                emit(title)
                movieDao.insert(result.data.results[0])
                delay(1000)
                emit("$title (Saved to DB)")
            }
            is Fail -> emit(result.e.message ?: "Failed")
        }
    }

}