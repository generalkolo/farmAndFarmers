package com.example.cleanWithCoRoutine.data.local.auth

import com.example.cleanWithCoRoutine.data.models.auth.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserLocal {
    suspend fun getUser(): Flow<UserEntity>
}