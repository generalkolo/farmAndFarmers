package com.example.cleanWithCoRoutine.data.mappers

import com.example.cleanWithCoRoutine.data.models.auth.UserEntity
import com.example.cleanWithCoRoutine.data.models.statistics.FarmAndFarmersDetailsEntity
import com.example.cleanWithCoRoutine.domain.models.auth.User
import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails

internal fun UserEntity.toDomain(): User = User(
    email, password
)

internal fun FarmAndFarmersDetailsEntity.toDomain(): FarmAndFarmersDetails =
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

