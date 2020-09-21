package net.alexandroid.samplesapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.main_fragment.*
import net.alexandroid.samplesapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.main_fragment) {
    private val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvVideoTitle.text = "We will show here a title of movie"
    }
}