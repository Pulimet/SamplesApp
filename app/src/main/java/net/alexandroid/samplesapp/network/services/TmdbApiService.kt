package net.alexandroid.samplesapp.network.services

import net.alexandroid.samplesapp.model.Tmdb
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.SimpleDateFormat
import java.util.*

interface TmdbApiService {
    companion object {
        private const val TMDB_API_KEY = "26596c147eacb8c3b84e0217b23ed41a"
        private fun getTodayDate(): String =
            SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())
    }

    @GET("3/discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = TMDB_API_KEY,
        @Query("page") page: Long = 1,
        @Query("sort_by") sortBy: String = "release_date.desc",
        @Query("release_date.lte") todayDate: String = getTodayDate(),
        @Query("vote_count.gte") minNumOfVotes: Int = 2
    ): Tmdb.Discover
}