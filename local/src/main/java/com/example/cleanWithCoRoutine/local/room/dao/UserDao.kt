package com.example.cleanWithCoRoutine.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cleanWithCoRoutine.local.models.auth.UserLocal

@Dao
interface UserDao {

    @Insert
    suspend fun saveDetails(user: UserLocal)

    @Query("SELECT * FROM User")
    suspend fun getUserDetails(): List<UserLocal>
}