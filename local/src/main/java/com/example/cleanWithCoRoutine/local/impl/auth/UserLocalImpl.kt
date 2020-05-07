package com.example.cleanWithCoRoutine.local.impl.auth

import com.example.cleanWithCoRoutine.data.local.auth.UserLocal
import com.example.cleanWithCoRoutine.data.models.auth.UserEntity
import com.example.cleanWithCoRoutine.local.mappers.toEntity
import com.example.cleanWithCoRoutine.local.room.dao.UserDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserLocalImpl @Inject constructor(
    private val userDao: UserDao
) : UserLocal {
    override suspend fun getUser(): Flow<UserEntity> = flow {
        emit(userDao.getUserDetails()[0].toEntity())
    }
}