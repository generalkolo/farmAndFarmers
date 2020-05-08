package com.example.cleanWithCoRoutine.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanWithCoRoutine.local.models.statistics.FarmAndFarmersDetailsLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface FarmAndFarmDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(details: FarmAndFarmersDetailsLocal)

    @Query("SELECT * FROM FARM_AND_FARM_DETAILS")
    fun getAllDetails(): Flow<List<FarmAndFarmersDetailsLocal>>
}