package net.alexandroid.samplesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

object Tmdb {
    data class Discover(
        val page: Int,
        @SerializedName("total_results") val totalResults: Int,
        @SerializedName("total_pages") val totalPages: Int,
        val results: MutableList<Movie>
    )

    @Entity(tableName = "movies")
    data class Movie(
        @PrimaryKey
        val id: Int,
        val title: String,
        @SerializedName("poster_path") val posterImg: String?,
        @SerializedName("backdrop_path") val backImg: String?,
        val overview: String,
        @SerializedName("release_date") val date: String,
        @SerializedName("vote_average") val vote: Double
    )
}