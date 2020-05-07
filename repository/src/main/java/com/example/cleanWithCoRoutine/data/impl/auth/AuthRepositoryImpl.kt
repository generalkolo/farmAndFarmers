package com.example.cleanWithCoRoutine.data.impl.auth

import com.example.cleanWithCoRoutine.data.local.auth.UserLocal
import com.example.cleanWithCoRoutine.data.mappers.toDomain
import com.example.cleanWithCoRoutine.domain.models.auth.User
import com.example.cleanWithCoRoutine.domain.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val userLocal: UserLocal
) : AuthRepository {
    override suspend fun getUser(): Flow<User> = userLocal.getUser().map { user -> user.toDomain() }
}