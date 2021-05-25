package com.coldfier.mynutrition3.cacheroom

import androidx.room.*
import com.coldfier.mynutrition3.models.Food

@Dao
interface CacheDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg food: Food)

    @Delete
    suspend fun deleteAll()

    @Query("select * from cache_table ")
    suspend fun getCachedFood(): List<Food>
}