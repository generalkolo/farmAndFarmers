package com.example.cleanWithCoRoutine.mappers

import com.example.cleanWithCoRoutine.domain.models.CountryDomainModel
import com.example.cleanWithCoRoutine.domain.models.StarWarsCharacter
import com.example.cleanWithCoRoutine.models.Country
import com.example.cleanWithCoRoutine.models.StarWarsCharacterUiModel


fun StarWarsCharacter.toPresentation(): StarWarsCharacterUiModel {
    return StarWarsCharacterUiModel(
        name,
        birthYear,
        height,
        height,
        url
    )
}

fun CountryDomainModel.toPresentation(): Country =
    Country(
        slug,
        country
    )
