package com.example.cleanWithCoRoutine.local.mappers

import com.example.cleanWithCoRoutine.data.models.CountryEntityModel
import com.example.cleanWithCoRoutine.local.models.CountryLocalModel

internal fun CountryEntityModel.toLocal(): CountryLocalModel =
    CountryLocalModel(
        slug,
        country
    )