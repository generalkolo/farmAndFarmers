package com.example.cleanWithCoRoutine.statistics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.statistics.R
import com.example.cleanWithCoRoutine.statistics.databinding.FragmentFarmDetailsBinding
import com.example.cleanWithCoRoutine.statistics.presentation.StatisticActivityViewModel
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError

private const val ARG_STEP_POSITION = "ARG_STEP_POSITION"

class FarmDetailsFragment : Fragment(), Step {
    private var _binding: FragmentFarmDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var statsActivityViewModel: StatisticActivityViewModel
    private var stepPosition: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stepPosition = it.getString(ARG_STEP_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFarmDetailsBinding.inflate(inflater, container, false)
        statsActivityViewModel =
            ViewModelProvider(activity!!).get(StatisticActivityViewModel::class.java)
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
            setOnSpinnerItemSelectedListener { parent, _, position, _ ->
                val clickedState = parent.getItemAtPosition(position)
                statsActivityViewModel.initStateLocationOfFarm(clickedState.toString())
            }
        }
    }

    private fun initClickListeners() {
        with(binding) {
            saveButton.setOnClickListener {
                //TODO: Send action to save to DB

            }
        }
    }

    override fun onSelected() {

    }


    override fun verifyStep(): VerificationError? {
        return null
    }

    override fun onError(error: VerificationError) {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(stepPosition: String) =
            FarmDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STEP_POSITION, stepPosition)
                }
            }
    }
}