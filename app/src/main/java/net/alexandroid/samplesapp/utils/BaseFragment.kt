package net.alexandroid.samplesapp.utils

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import net.alexandroid.utils.mylogkt.logD

abstract class BaseFragment(layout: Int) : Fragment(layout) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD(javaClass.simpleName)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logD(javaClass.simpleName)
    }

    override fun onDetach() {
        super.onDetach()
        logD(javaClass.simpleName)
    }
}