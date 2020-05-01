package com.example.cleanWithCoRoutine.data.mappers

import com.example.cleanWithCoRoutine.data.models.*
import com.example.cleanWithCoRoutine.domain.models.*


internal fun StarWarsCharacterEntity.toDomain(): StarWarsCharacter {
    return StarWarsCharacter(
        name,
        birthYear,
        height,
        url
    )
}

internal fun StarWarsCharacterFilmEntity.toDomain(): StarWarsCharacterFilm =
    StarWarsCharacterFilm(
        title,
        openingCrawl
    )

internal fun StarWarsCharacterPlanetEntity.toDomain(): StarWarsCharacterPlanet =
    StarWarsCharacterPlanet(
        name,
        population
    )

internal fun StarWarsCharacterSpeciesEntity.toDomain(): StarWarsCharacterSpecies =
    StarWarsCharacterSpecies(
        name,
        language
    )

internal fun CountryEntityModel.toDomain(): CountryDomainModel =
    CountryDomainModel(
        slug,
        country
    )

