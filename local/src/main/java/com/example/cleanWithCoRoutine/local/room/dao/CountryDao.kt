package com.example.cleanWithCoRoutine.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanWithCoRoutine.local.models.CountryLocalModel

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryLocalModel>)

    @Query("SELECT * FROM country")
    suspend fun getAllCountries(): List<CountryLocalModel>

}