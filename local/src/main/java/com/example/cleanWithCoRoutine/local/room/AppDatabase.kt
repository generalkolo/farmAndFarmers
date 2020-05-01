package com.example.cleanWithCoRoutine.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cleanWithCoRoutine.local.models.CountryLocalModel
import com.example.cleanWithCoRoutine.local.room.dao.CountryDao
import com.example.cleanWithCoRoutine.local.utils.DB_NAME

@Database(entities = [CountryLocalModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getCountryDao(): CountryDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: buildDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, DB_NAME
        ).build()
    }

}