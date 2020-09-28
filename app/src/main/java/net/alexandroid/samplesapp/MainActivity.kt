package net.alexandroid.samplesapp

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import net.alexandroid.samplesapp.ui.NavigationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    private val navViewModel: NavigationViewModel by viewModel()
    private lateinit var navController: NavController

    override fun onStart() {
        super.onStart()
        navController = findNavController(R.id.nav_host_fragment)
        navViewModel.getNavEvent().observe(this) {
            navController.navigate(it)
        }
    }
}