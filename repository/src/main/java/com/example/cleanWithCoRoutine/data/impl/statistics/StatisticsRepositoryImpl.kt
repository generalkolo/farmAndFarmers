package com.example.cleanWithCoRoutine.data.impl.statistics

import com.example.cleanWithCoRoutine.data.local.statistics.StatisticsLocal
import com.example.cleanWithCoRoutine.data.mappers.toDomain
import com.example.cleanWithCoRoutine.data.mappers.toEntity
import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails
import com.example.cleanWithCoRoutine.domain.repository.statistics.StatisticsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StatisticsRepositoryImpl @Inject constructor(
    private val statisticsLocal: StatisticsLocal
) : StatisticsRepository {
    override suspend fun getAllDetails(): Flow<List<FarmAndFarmersDetails>> =
        statisticsLocal.getAllDetails().map { detailsList ->
            detailsList.map { detail ->
                detail.toDomain()
            }
        }

    override suspend fun insertDetails(details: FarmAndFarmersDetails) =
        statisticsLocal.insertDetails(
            details.toEntity()
        )
}