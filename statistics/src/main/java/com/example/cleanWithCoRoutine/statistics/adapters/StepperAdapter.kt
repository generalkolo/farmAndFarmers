package com.example.cleanWithCoRoutine.statistics.adapters

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.cleanWithCoRoutine.statistics.R
import com.example.cleanWithCoRoutine.statistics.presentation.fragments.FarmDetailsFragment
import com.example.cleanWithCoRoutine.statistics.presentation.fragments.FarmerDetailsFragment
import com.stepstone.stepper.Step
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter
import com.stepstone.stepper.viewmodel.StepViewModel


class StepperAdapter(fm: FragmentManager, context: Context) :
    AbstractFragmentStepAdapter(fm, context) {

    private val CURRENT_STEP_POSITION_KEY = "CURRENT_STEP_POSITION_KEY"

    override fun getCount(): Int = 2

    override fun createStep(position: Int): Step {
        Log.e("Adapter", position.toString())
        return when (position) {
            0 -> {
                val step = FarmerDetailsFragment()
                val b = Bundle()
                b.putInt(CURRENT_STEP_POSITION_KEY, position)
                step.arguments = b
                step
            }
            1 -> {
                val step = FarmDetailsFragment.newInstance(CURRENT_STEP_POSITION_KEY)
                step
            }
            else ->
                throw IllegalArgumentException("Unsupported position: $position")
        }
    }

    override fun getViewModel(position: Int): StepViewModel {
        val builder = StepViewModel.Builder(context)

        when (position) {
            0 -> {
                builder.setTitle(R.string.farmers_info)
            }
            1 -> {
                builder.setTitle(R.string.farm_info)
            }
            else ->
                throw IllegalArgumentException("Unsupported position: $position")
        }
        return builder.create()
    }

}