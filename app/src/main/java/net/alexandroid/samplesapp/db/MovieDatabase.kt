package net.alexandroid.samplesapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import net.alexandroid.samplesapp.model.Tmdb

@Database(entities = [Tmdb.Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}