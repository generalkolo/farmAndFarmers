package com.example.cleanWithCoRoutine.domain.usecases.statistics

import com.example.cleanWithCoRoutine.domain.repository.statistics.StatisticsRepository
import javax.inject.Inject

class GetAllDetailsUsecase @Inject constructor(
    private val statisticsRepository: StatisticsRepository
) {
    suspend operator fun invoke() = statisticsRepository.getAllDetails()
}