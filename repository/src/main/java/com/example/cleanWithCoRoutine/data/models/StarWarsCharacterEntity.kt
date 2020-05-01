package com.example.cleanWithCoRoutine.data.models

/**
 * Provides a shallow character model with minimal data
 */
data class StarWarsCharacterEntity(
    var name: String,
    var birthYear: String,
    var height: String,
    var url: String
)