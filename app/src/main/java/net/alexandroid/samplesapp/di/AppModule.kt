package net.alexandroid.samplesapp.di

import net.alexandroid.samplesapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // ViewModels
    viewModel { MainViewModel() }

}