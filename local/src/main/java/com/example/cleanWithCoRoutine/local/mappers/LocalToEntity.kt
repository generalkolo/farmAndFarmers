package com.example.cleanWithCoRoutine.local.mappers

import com.example.cleanWithCoRoutine.data.models.CountryEntityModel
import com.example.cleanWithCoRoutine.data.models.auth.UserEntity
import com.example.cleanWithCoRoutine.data.models.statistics.FarmAndFarmersDetailsEntity
import com.example.cleanWithCoRoutine.local.models.CountryLocalModel
import com.example.cleanWithCoRoutine.local.models.auth.UserLocal
import com.example.cleanWithCoRoutine.local.models.statistics.FarmAndFarmersDetailsLocal

internal fun CountryLocalModel.toEntity(): CountryEntityModel =
    CountryEntityModel(
        slug,
        country
    )

internal fun UserLocal.toEntity(): UserEntity = UserEntity(email, password)

internal fun FarmAndFarmersDetailsLocal.toEntity(): FarmAndFarmersDetailsEntity =
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