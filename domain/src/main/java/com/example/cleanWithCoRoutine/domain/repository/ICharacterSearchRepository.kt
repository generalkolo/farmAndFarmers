package com.example.cleanWithCoRoutine.domain.repository

import com.example.cleanWithCoRoutine.domain.models.StarWarsCharacter
import kotlinx.coroutines.flow.Flow

interface ICharacterSearchRepository {
    suspend fun searchCharacters(params: String): Flow<List<StarWarsCharacter>>
}