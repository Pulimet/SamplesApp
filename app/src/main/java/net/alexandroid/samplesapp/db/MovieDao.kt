package net.alexandroid.samplesapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import net.alexandroid.samplesapp.model.Tmdb

@Dao
interface MovieDao {

    @Query("SELECT * from movies")
    fun getMovies(): Flow<List<Tmdb.Movie>>

    fun getMoviesChange() = getMovies().distinctUntilChanged()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Tmdb.Movie)

    @Query("DELETE FROM movies")
    suspend fun deleteAll()
}