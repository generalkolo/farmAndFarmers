package com.example.cleanWithCoRoutine.data.mappers

import com.example.cleanWithCoRoutine.data.models.CountryEntityModel
import com.example.cleanWithCoRoutine.data.models.auth.UserEntity
import com.example.cleanWithCoRoutine.data.models.statistics.FarmAndFarmersDetailsEntity
import com.example.cleanWithCoRoutine.domain.models.CountryDomainModel
import com.example.cleanWithCoRoutine.domain.models.auth.User
import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails

internal fun CountryDomainModel.toEntity(): CountryEntityModel =
    CountryEntityModel(
        slug,
        country
    )

internal fun User.toEntity(): UserEntity = UserEntity(
    email, password
)

internal fun FarmAndFarmersDetails.toEntity(): FarmAndFarmersDetailsEntity =
    FarmAndFarmersDetailsEntity(
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