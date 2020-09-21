package net.alexandroid.samplesapp.ui.main

import androidx.fragment.app.Fragment
import net.alexandroid.samplesapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.main_fragment) {
    private val viewModel: MainViewModel by viewModel()
}