package com.example.cleanWithCoRoutine.statistics.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.statistics.R

class StatisticsActivity : AppCompatActivity() {
    private lateinit var statsActivityViewModel: StatisticActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statsActivityViewModel =
            ViewModelProvider(this).get(StatisticActivityViewModel::class.java)
        setContentView(R.layout.activity_statistics)
//        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }
}