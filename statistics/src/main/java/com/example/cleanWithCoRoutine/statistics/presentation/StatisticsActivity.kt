package com.example.cleanWithCoRoutine.statistics.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.statistics.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class StatisticsActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var statsActivityViewModel: StatisticActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statsActivityViewModel =
            ViewModelProvider(this, viewModelFactory).get(StatisticActivityViewModel::class.java)
        setContentView(R.layout.activity_statistics)
    }
}