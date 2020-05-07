package com.example.cleanWithCoRoutine.domain.repository.statistics

import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails
import kotlinx.coroutines.flow.Flow

interface StatisticsRepository {
    suspend fun getAllDetails(): Flow<List<FarmAndFarmersDetails>>

    suspend fun insertDetails(details: FarmAndFarmersDetails)
}