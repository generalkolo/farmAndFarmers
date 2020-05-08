package com.example.cleanWithCoRoutine.local.impl.statistics

import com.example.cleanWithCoRoutine.data.local.statistics.StatisticsLocal
import com.example.cleanWithCoRoutine.data.models.statistics.FarmAndFarmersDetailsEntity
import com.example.cleanWithCoRoutine.local.mappers.toEntity
import com.example.cleanWithCoRoutine.local.mappers.toLocal
import com.example.cleanWithCoRoutine.local.room.dao.FarmAndFarmDetailsDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StatisticsLocalImpl @Inject constructor(
    private val farmDetailsDao: FarmAndFarmDetailsDao
) : StatisticsLocal {
    override suspend fun getAllDetails(): Flow<List<FarmAndFarmersDetailsEntity>> =
        farmDetailsDao.getAllDetails().map { listOfDetails ->
            listOfDetails.map {
                it.toEntity()
            }
        }

    override suspend fun insertDetails(details: FarmAndFarmersDetailsEntity) {
        farmDetailsDao.insertDetails(details.toLocal())
    }
}