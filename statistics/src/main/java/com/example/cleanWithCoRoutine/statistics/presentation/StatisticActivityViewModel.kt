package com.example.cleanWithCoRoutine.statistics.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class StatisticActivityViewModel : ViewModel() {
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
}