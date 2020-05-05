package com.example.cleanWithCoRoutine.statistics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cleanWithCoRoutine.statistics.adapters.StepperAdapter
import com.example.cleanWithCoRoutine.statistics.databinding.FragmentDetailsContainerBinding

class DetailsContainerFragment : Fragment() {
    private var _binding: FragmentDetailsContainerBinding? = null
    private val binding
        get() = _binding!!

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
    }

    private fun initViews() {
        initStepperLayout()
    }

    private fun initStepperLayout() {
        with(binding) {
            stepperLayout.adapter = StepperAdapter(
                activity!!.supportFragmentManager,
                this@DetailsContainerFragment.requireContext()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}