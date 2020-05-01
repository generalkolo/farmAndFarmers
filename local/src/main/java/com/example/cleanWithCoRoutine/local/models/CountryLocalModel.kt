package com.example.cleanWithCoRoutine.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryLocalModel (
    @PrimaryKey
    val slug: String,
    val country: String
)