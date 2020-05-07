package com.example.cleanWithCoRoutine.domain.repository.auth

import com.example.cleanWithCoRoutine.domain.models.auth.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun getUser(): Flow<User>
}