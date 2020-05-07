package com.example.cleanWithCoRoutine.data.local.statistics

import com.example.cleanWithCoRoutine.data.models.statistics.FarmAndFarmersDetailsEntity
import kotlinx.coroutines.flow.Flow

interface StatisticsLocal {
    suspend fun getAllDetails(): Flow<List<FarmAndFarmersDetailsEntity>>

    suspend fun insertDetails(details: FarmAndFarmersDetailsEntity)
}