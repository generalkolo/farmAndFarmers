package com.example.cleanWithCoRoutine.data.mappers

import com.example.cleanWithCoRoutine.data.models.*
import com.example.cleanWithCoRoutine.data.models.auth.UserEntity
import com.example.cleanWithCoRoutine.data.models.statistics.FarmAndFarmersDetailsEntity
import com.example.cleanWithCoRoutine.domain.models.*
import com.example.cleanWithCoRoutine.domain.models.auth.User
import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails


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

