package com.example.cleanWithCoRoutine.local.mappers

import com.example.cleanWithCoRoutine.data.models.CountryEntityModel
import com.example.cleanWithCoRoutine.data.models.statistics.FarmAndFarmersDetailsEntity
import com.example.cleanWithCoRoutine.local.models.CountryLocalModel
import com.example.cleanWithCoRoutine.local.models.statistics.FarmAndFarmersDetailsLocal

internal fun CountryEntityModel.toLocal(): CountryLocalModel =
    CountryLocalModel(
        slug,
        country
    )

internal fun FarmAndFarmersDetailsEntity.toLocal(): FarmAndFarmersDetailsLocal =
    FarmAndFarmersDetailsLocal(
        null,
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