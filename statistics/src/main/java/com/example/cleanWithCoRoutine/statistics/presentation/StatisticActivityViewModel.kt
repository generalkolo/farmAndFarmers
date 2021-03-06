package com.example.cleanWithCoRoutine.statistics.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanWithCoRoutine.common.utils.Event
import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails
import com.example.cleanWithCoRoutine.domain.usecases.statistics.GetAllDetailsUsecase
import com.example.cleanWithCoRoutine.domain.usecases.statistics.InsertDetailsUsecase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class StatisticActivityViewModel @Inject constructor(
    private val getAllDetailsUsecase: GetAllDetailsUsecase,
    private val insertDetailsUsecase: InsertDetailsUsecase
) : ViewModel() {

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

    private val _showEmptyDetailsContainer = MutableLiveData<Boolean>()
    val showEmptyDetailsContainer = _showEmptyDetailsContainer as LiveData<Boolean>

    private val _allDetails = MutableLiveData<List<FarmAndFarmersDetails>>()
    val allDetails = _allDetails as LiveData<List<FarmAndFarmersDetails>>

    private val _showLatLngOnMap = MutableLiveData<Event<Boolean>>()
    val showLatLngOnMap = _showLatLngOnMap as LiveData<Event<Boolean>>

    private val _moveToDashboard = MutableLiveData<Event<Boolean>>()
    val moveToDashboard = _moveToDashboard as LiveData<Event<Boolean>>

    private val _moveToFarmDetailsForm = MutableLiveData<Event<Boolean>>()
    val moveToFarmDetailsForm = _moveToFarmDetailsForm as LiveData<Event<Boolean>>

    init {
        _showEmptyDetailsContainer.postValue(true)
        viewModelScope.launch {
            getAllDetailsUsecase.invoke().collect { farmDetails ->
                _allDetails.postValue(farmDetails)
                if (farmDetails.isNotEmpty()) _showEmptyDetailsContainer.postValue(false)
            }
        }
    }

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

    private fun saveDetails() {
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

        resetAllValues()
        _moveToDashboard.postValue(Event(true))
    }

    private fun resetAllValues() {
        firstName = ""
        firstName = ""
        lastName = ""
        phoneNumber = ""
        dateOfBirth = ""
        farmersAge = ""
        farmersStateOfOrigin = ""
        farmName = ""
        stateLocationOfFarm = ""
        farmAddress = ""
        farmLongitude = ""
        farmLatitude = ""
    }

    fun verifyLatAndLng(lat: String, long: String) {
        if (lat.isEmpty() || long.isEmpty()) {
            _toastMessage.postValue(Event("Neither Latitude or Longitude can be empty"))
        } else if (!isValidLatLng(lat.toDouble(), long.toDouble())) {
            _toastMessage.postValue(Event("Invalid Lat or Long entered"))
        } else {
            _showLatLngOnMap.postValue(Event(true))
        }
    }

    private fun isValidLatLng(lat: Double, lng: Double): Boolean {
        Log.d("gggg", "$lat $lng")
        if (lat < -90 || lat > 90) {
            return false
        } else if (lng < -180 || lng > 180) {
            return false
        }
        return true
    }

    fun confirmFarmersFormIsFilled() {
        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || dateOfBirth.isEmpty() ||
            farmersStateOfOrigin.isEmpty()
        ) {
            _toastMessage.postValue(Event("Please ensure that all fields are filled correctly"))
        } else {
            _moveToFarmDetailsForm.postValue(Event(true))
        }
    }

    fun confirmFarmsFormIsFilled() {
        if (farmName.isEmpty() || stateLocationOfFarm.isEmpty() || farmLongitude.isEmpty() || farmLatitude.isEmpty()
        ) {
            _toastMessage.postValue(Event("Please ensure that all fields are filled correctly"))
        } else {
            saveDetails()
        }
    }
}