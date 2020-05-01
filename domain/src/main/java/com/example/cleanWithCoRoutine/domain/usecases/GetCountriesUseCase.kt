package com.example.cleanWithCoRoutine.domain.usecases

import com.example.cleanWithCoRoutine.domain.repository.ICovid19CasesRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val covid19CasesRepository: ICovid19CasesRepository
) {

    suspend operator fun invoke() = covid19CasesRepository.getCountries()

}