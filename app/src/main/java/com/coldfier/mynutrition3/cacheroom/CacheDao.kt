package com.coldfier.mynutrition3.cacheroom

import androidx.room.*

@Dao
interface CacheDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg food: Food)

    @Query("delete from cache_table")
    suspend fun deleteAll()

    @Query("select * from cache_table ")
    suspend fun getCachedFood(): List<Food>
}