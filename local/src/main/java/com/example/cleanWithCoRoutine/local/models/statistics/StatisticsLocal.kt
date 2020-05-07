package com.example.cleanWithCoRoutine.local.models.statistics

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FARM_AND_FARM_DETAILS")
data class FarmAndFarmersDetailsLocal(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val dateOfBirth: String,
    val farmersAge: String,
    val farmersStateOfOrigin: String,
    val farmName: String,
    val stateLocationOfFarm: String,
    val farmAddress: String,
    val farmLongitude: String,
    val farmLatitude: String
)