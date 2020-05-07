package com.example.cleanWithCoRoutine.local.mappers

import com.example.cleanWithCoRoutine.data.models.statistics.FarmAndFarmersDetailsEntity
import com.example.cleanWithCoRoutine.local.models.statistics.FarmAndFarmersDetailsLocal

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