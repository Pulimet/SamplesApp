package net.alexandroid.samplesapp.ui.main

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.main_fragment.*
import net.alexandroid.samplesapp.R
import net.alexandroid.samplesapp.ui.NavigationViewModel
import net.alexandroid.samplesapp.utils.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(R.layout.main_fragment), View.OnClickListener {
    private val viewModel: MainViewModel by viewModel()
    private val navViewModel: NavigationViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovieTitle().observe(viewLifecycleOwner) {
            tvVideoTitle.text = it
        }

        btnDataStore.setOnClickListener(this)
    }

    // View.OnClickListener
    override fun onClick(v: View?) {
        when (v) {
            btnDataStore -> navViewModel.onBtnDataStoreClick()
        }
    }
}