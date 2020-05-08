package com.example.cleanWithCoRoutine.statistics.presentation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.cleanWithCoRoutine.statistics.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_statistics.*
import javax.inject.Inject

class StatisticsActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var statsActivityViewModel: StatisticActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        Log.d("GGGG", "We are here")

        statsActivityViewModel =
            ViewModelProvider(this, viewModelFactory).get(StatisticActivityViewModel::class.java)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupWithNavController(toolbar, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}