package com.coldfier.mynutrition3.cacheroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Food::class], version = 1, exportSchema = false)
abstract class CacheDatabase: RoomDatabase() {
    abstract val cacheDao: CacheDao

    companion object {

        private lateinit var INSTANCE: CacheDatabase

        fun getCacheDatabase(context: Context): CacheDatabase {
            synchronized(CacheDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, CacheDatabase::class.java, "cache").build()
                }

            }
            return INSTANCE
        }
    }
}
