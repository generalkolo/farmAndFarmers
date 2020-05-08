package com.example.cleanWithCoRoutine.statistics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cleanWithCoRoutine.statistics.adapters.StepperAdapter
import com.example.cleanWithCoRoutine.statistics.databinding.FragmentDetailsContainerBinding
import com.example.cleanWithCoRoutine.statistics.presentation.StatisticActivityViewModel
import com.example.cleanWithCoRoutine.statistics.utils.EventObserver
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailsContainerFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentDetailsContainerBinding? = null
    private val binding
        get() = _binding!!

    private val statsActivityViewModel by activityViewModels<StatisticActivityViewModel> {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initObservers() {
        statsActivityViewModel.moveToDashboard.observe(viewLifecycleOwner, EventObserver {
            if (it) {
                val action = DetailsContainerFragmentDirections.popToDashboardFragment()
                findNavController().navigate(action)
            }
        })
        statsActivityViewModel.moveToFarmDetailsForm.observe(viewLifecycleOwner, EventObserver {
            if (it) {
                binding.stepperLayout.currentStepPosition = 1
            }
        })
    }

    private fun initViews() {
        initStepperLayout()
    }

    private fun initStepperLayout() {
        with(binding.stepperLayout) {
            adapter = StepperAdapter(
                childFragmentManager,
                this@DetailsContainerFragment.requireContext()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}