package com.example.cleanWithCoRoutine.local.models.auth

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserLocal(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    val email: String,
    val password: String
)