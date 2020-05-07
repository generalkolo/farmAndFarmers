package com.example.cleanWithCoRoutine.domain.usecases.statistics

import com.example.cleanWithCoRoutine.domain.models.statistics.FarmAndFarmersDetails
import com.example.cleanWithCoRoutine.domain.repository.statistics.StatisticsRepository
import javax.inject.Inject

class InsertDetailsUsecase @Inject constructor(
    private val statisticsRepository: StatisticsRepository
) {
    suspend operator fun invoke(details: FarmAndFarmersDetails) =
        statisticsRepository.insertDetails(details)
}