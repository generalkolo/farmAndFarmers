package com.example.cleanWithCoRoutine.statistics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.statistics.R
import com.example.cleanWithCoRoutine.statistics.databinding.FragmentClickedFarmDetailsBinding
import com.example.cleanWithCoRoutine.statistics.presentation.StatisticActivityViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ClickedFarmDetailsFragment : DaggerFragment(), OnMapReadyCallback {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentClickedFarmDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var mMap: GoogleMap

    private val statsActivityViewModel by activityViewModels<StatisticActivityViewModel> {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClickedFarmDetailsBinding.inflate(inflater, container, false)
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.farms_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        binding.statsViewModel = statsActivityViewModel
        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val location = LatLng(
            statsActivityViewModel.clickedFarmDetails.farmLatitude.toDouble(),
            statsActivityViewModel.clickedFarmDetails.farmLongitude.toDouble()
        )
        val markerOptions = MarkerOptions().position(location).title("Farm Location")
        mMap.addMarker(markerOptions)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15.0F))
    }
}