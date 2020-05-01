package com.example.cleanWithCoRoutine.mappers

import com.example.cleanWithCoRoutine.domain.models.CountryDomainModel
import com.example.cleanWithCoRoutine.models.Country

fun Country.toDomain(): CountryDomainModel =
    CountryDomainModel(
        slug,
        country
    )