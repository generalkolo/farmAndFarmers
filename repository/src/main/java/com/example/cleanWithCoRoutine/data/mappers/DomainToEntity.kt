package com.example.cleanWithCoRoutine.data.mappers

import com.example.cleanWithCoRoutine.data.models.CountryEntityModel
import com.example.cleanWithCoRoutine.domain.models.CountryDomainModel

internal fun CountryDomainModel.toEntity(): CountryEntityModel =
    CountryEntityModel(
        slug,
        country
    )