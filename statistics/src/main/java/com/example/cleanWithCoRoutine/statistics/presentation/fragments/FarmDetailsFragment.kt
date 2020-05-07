package com.example.cleanWithCoRoutine.statistics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.statistics.R
import com.example.cleanWithCoRoutine.statistics.databinding.FragmentFarmDetailsBinding
import com.example.cleanWithCoRoutine.statistics.presentation.StatisticActivityViewModel
import com.example.cleanWithCoRoutine.statistics.utils.EventObserver
import com.example.cleanWithCoRoutine.statistics.utils.showToast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val ARG_STEP_POSITION = "ARG_STEP_POSITION"

class FarmDetailsFragment : DaggerFragment(), Step, OnMapReadyCallback {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentFarmDetailsBinding? = null
    private val binding get() = _binding!!

    private val statsActivityViewModel by activityViewModels<StatisticActivityViewModel> {
        viewModelFactory
    }

    private var stepPosition: String? = null

    private lateinit var mMap: GoogleMap

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
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.farms_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
        initObservers()
    }

    private fun initObservers() {
        statsActivityViewModel.toastMessage.observe(this, EventObserver { message ->
            showToast(message)
        })
        statsActivityViewModel.showLatLngOnMap.observe(this, EventObserver { showOnMap ->
            if (showOnMap) {
                placeMarkerOnMap(
                    LatLng(
                        binding.farmLatitudeTextInputEditText.text.toString().toDouble(),
                        binding.farmLongitudeTextInputEditText.text.toString().toDouble()
                    )
                )
            }
        })
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
                statsActivityViewModel.insertDetails()
            }
            displayOnMap.setOnClickListener {
                statsActivityViewModel.verifyLatAndLng(
                    farmLatitudeTextInputEditText.text?.trim().toString(),
                    farmLongitudeTextInputEditText.text?.trim().toString()
                )
            }
        }
    }

    private fun placeMarkerOnMap(location: LatLng) {
        val markerOptions = MarkerOptions().position(location).title("Farm Location")
        mMap.addMarker(markerOptions)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15.0F))
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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }
}