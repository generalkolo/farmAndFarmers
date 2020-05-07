package com.example.cleanWithCoRoutine.statistics.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails
import com.example.cleanWithCoRoutine.domain.usecases.statistics.GetAllDetailsUsecase
import com.example.cleanWithCoRoutine.domain.usecases.statistics.InsertDetailsUsecase
import com.example.cleanWithCoRoutine.statistics.utils.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class StatisticActivityViewModel @Inject constructor(
    private val getAllDetailsUsecase: GetAllDetailsUsecase,
    private val insertDetailsUsecase: InsertDetailsUsecase
) : ViewModel() {

    init {
        viewModelScope.launch {
            getAllDetailsUsecase.invoke().collect { farmDetails ->
                _allDetails.postValue(farmDetails)
            }
        }
    }

    var firstName = ""
    var lastName = ""
    var phoneNumber = ""
    private var dateOfBirth = ""
    var farmersAge = "0"
    private var farmersStateOfOrigin = ""
    var farmName = ""
    var stateLocationOfFarm = ""
    var farmAddress = ""
    var farmLongitude = ""
    var farmLatitude = ""

    lateinit var clickedFarmDetails: FarmAndFarmersDetails

    fun initClickedFarmDetails(details: FarmAndFarmersDetails) {
        this.clickedFarmDetails = details
    }

    private val _toastMessage = MutableLiveData<Event<String>>()
    val toastMessage = _toastMessage as LiveData<Event<String>>

    private val _allDetails = MutableLiveData<List<FarmAndFarmersDetails>>()
    val allDetails = _allDetails as LiveData<List<FarmAndFarmersDetails>>

    private val _showLatLngOnMap = MutableLiveData<Event<Boolean>>()
    val showLatLngOnMap = _showLatLngOnMap as LiveData<Event<Boolean>>

    private val _moveToDashboard = MutableLiveData<Event<Boolean>>()
    val moveToDashboard = _moveToDashboard as LiveData<Event<Boolean>>

    fun initDateOfBirth(dateOfBirth: String) {
        this.dateOfBirth = dateOfBirth
    }

    fun initFarmersAge(age: String) {
        this.farmersAge = age
    }

    fun initFarmersStateOfOrigin(stateOfOrigin: String) {
        this.farmersStateOfOrigin = stateOfOrigin
    }

    fun initStateLocationOfFarm(state: String) {
        this.stateLocationOfFarm = state
    }

    fun revealContents() {
        Log.d(
            "VALUEEEEES",
            "$firstName $lastName $phoneNumber $dateOfBirth $farmersAge$farmersStateOfOrigin"
        )
    }

    fun insertDetails() {
        viewModelScope.launch {
            insertDetailsUsecase.invoke(
                FarmAndFarmersDetails(
                    firstName,
                    lastName,
                    phoneNumber,
                    dateOfBirth,
                    farmersAge,
                    farmersStateOfOrigin,
                    farmName,
                    stateLocationOfFarm,
                    farmAddress,
                    farmLongitude,
                    farmLatitude
                )
            )
        }
        _moveToDashboard.postValue(Event(true))
    }

    fun verifyLatAndLng(lat: String, long: String) {
        if (lat.isEmpty() || long.isEmpty()) {
            _toastMessage.postValue(Event("Neither Latitude or Longitude can be empty"))
        } else {
            _showLatLngOnMap.postValue(Event(true))
        }
    }
}