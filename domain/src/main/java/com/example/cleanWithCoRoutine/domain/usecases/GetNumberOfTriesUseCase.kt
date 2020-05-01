package com.example.cleanWithCoRoutine.domain.usecases

import com.example.cleanWithCoRoutine.domain.repository.ISharedPreferencesRepository
import javax.inject.Inject

class GetNumberOfTriesUseCase @Inject constructor(
    private val sharedPreferencesRepository: ISharedPreferencesRepository
) {

    suspend operator fun invoke() = sharedPreferencesRepository.getNumberOfTries()

}