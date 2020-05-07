package com.example.cleanWithCoRoutine.domain.usecases.auth

import com.example.cleanWithCoRoutine.domain.repository.auth.AuthRepository
import javax.inject.Inject

class GetDefaultUserLoginUsecase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.getUser()

}