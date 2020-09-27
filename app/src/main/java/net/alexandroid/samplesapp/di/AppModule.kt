package net.alexandroid.samplesapp.di

import androidx.room.Room
import net.alexandroid.samplesapp.db.MovieDatabase
import net.alexandroid.samplesapp.network.NetworkObjectsCreator
import net.alexandroid.samplesapp.network.services.TmdbApiService
import net.alexandroid.samplesapp.repo.MovieRepo
import net.alexandroid.samplesapp.ui.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

const val TMDB_URL = "https://api.themoviedb.org/"

val appModule = module {

    // DB
    single { Room.databaseBuilder(get(), MovieDatabase::class.java, "movies_database").build() }
    single { get<MovieDatabase>().movieDao() }

    // Network
    single { NetworkObjectsCreator.createOkHttpClient(androidContext()) }
    single { NetworkObjectsCreator.createWebService<TmdbApiService>(get(), TMDB_URL) }

    // Repositories
    single { MovieRepo(get(), get()) }

    // ViewModels
    viewModel { MainViewModel(get()) }

}