package com.example.cleanWithCoRoutine.statistics.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cleanWithCoRoutine.statistics.R
import com.example.cleanWithCoRoutine.statistics.databinding.FragmentFarmersDetailsBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError

class FarmerDetailsFragment : Fragment(), Step {

    private var _binding: FragmentFarmersDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFarmersDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        (activity as AppCompatActivity).supportActionBar?.hide()
        initSpinnerItems()
        initClickListeners()
    }

    private fun initSpinnerItems() {
        with(binding.stateSpinner) {
            val states = resources.getStringArray(R.array.nigeria_state).toList()
            attachDataSource(states)
            //TODO: Set clicked state in viewModel
            setOnSpinnerItemSelectedListener { parent, _, position, _ ->
                val clickedState = parent.getItemAtPosition(position)
                clickedState.toString()
            }
        }
    }

    private fun initClickListeners() {
        with(binding) {
            dateOfBirthPicker.container.setOnClickListener {
                val builder = MaterialDatePicker.Builder.datePicker()
                val picker = builder.build()
                picker.show(activity!!.supportFragmentManager, picker.toString())
                picker.addOnPositiveButtonClickListener {
                    Log.d(
                        "DatePickerFragment",
                        "Date String = ${picker.headerText}:: Date epoch value = $it"
                    )
                }
            }
            nextButton.setOnClickListener {
//                val action = FarmerDetailsFragment
            }
        }
    }

    override fun onSelected() {
    }

    override fun verifyStep(): VerificationError? {
        return null
    }

    override fun onError(error: VerificationError) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}