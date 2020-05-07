package com.example.cleanWithCoRoutine.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cleanWithCoRoutine.local.models.auth.UserLocal
import com.example.cleanWithCoRoutine.local.models.statistics.FarmAndFarmersDetailsLocal
import com.example.cleanWithCoRoutine.local.room.dao.FarmAndFarmDetailsDao
import com.example.cleanWithCoRoutine.local.room.dao.UserDao
import com.example.cleanWithCoRoutine.local.utils.DB_NAME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

@Database(
    entities = [FarmAndFarmersDetailsLocal::class, UserLocal::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getFarmAndFarmDetailsDao(): FarmAndFarmDetailsDao
    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): AppDatabase = instance
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
        ).allowMainThreadQueries().addCallback(object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(IO).launch {
                    invoke(context).getUserDao().saveDetails(
                        UserLocal(
                            email = "test@theagromall.com",
                            password = "password"
                        )
                    )
                }
            }
        }).fallbackToDestructiveMigration().build()
    }
}