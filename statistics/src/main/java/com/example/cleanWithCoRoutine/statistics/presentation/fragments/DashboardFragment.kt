package com.example.cleanWithCoRoutine.statistics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails
import com.example.cleanWithCoRoutine.statistics.adapters.FarmAndFarmDetailsAdapter
import com.example.cleanWithCoRoutine.statistics.adapters.FarmClickedListener
import com.example.cleanWithCoRoutine.statistics.databinding.FragmentDashboardBinding
import com.example.cleanWithCoRoutine.statistics.presentation.StatisticActivityViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DashboardFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val statsActivityViewModel by activityViewModels<StatisticActivityViewModel> {
        viewModelFactory
    }
    private lateinit var farmDetailsAdapter: FarmAndFarmDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        initObservers()
    }

    private fun initObservers() {
        statsActivityViewModel.allDetails.observe(viewLifecycleOwner, Observer { data ->
            initAdapter(data)
        })
    }

    private fun initAdapter(data: List<FarmAndFarmersDetails>?) {
        data?.let {
            farmDetailsAdapter = FarmAndFarmDetailsAdapter(it, FarmClickedListener {
                //TODO: Show item that was clicked
            })
        }
    }

    private fun setOnClickListeners() {
        with(binding) {
            addFarmFab.setOnClickListener {
                val action = DashboardFragmentDirections.FirstFragmentToFarmerDetailsFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}