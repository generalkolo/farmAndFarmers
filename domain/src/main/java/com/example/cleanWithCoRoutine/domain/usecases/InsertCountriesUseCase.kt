package com.example.cleanWithCoRoutine.domain.usecases

import com.example.cleanWithCoRoutine.domain.models.CountryDomainModel
import com.example.cleanWithCoRoutine.domain.repository.ICovid19CasesRepository
import javax.inject.Inject

class InsertCountriesUseCase @Inject constructor(
    private val covid19CasesRepository: ICovid19CasesRepository
) {

    suspend operator fun invoke(countries: List<CountryDomainModel>) =
        covid19CasesRepository.insertCountries(countries)

}