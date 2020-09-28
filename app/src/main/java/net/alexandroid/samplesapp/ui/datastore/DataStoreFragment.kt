package net.alexandroid.samplesapp.ui.datastore

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.fragment_data_store.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import net.alexandroid.samplesapp.R
import net.alexandroid.samplesapp.utils.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataStoreFragment : BaseFragment(R.layout.fragment_data_store), View.OnClickListener {

    private val viewModel: DataStoreViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.userPreferencesFlow.collect {
                tvResult.text = it
            }
        }

        btnSave.setOnClickListener(this)
    }

    // View.OnClickListener
    override fun onClick(v: View?) {
        when (v) {
            btnSave -> viewModel.onBtnSaveClick(etText.text.toString())
        }
    }
}