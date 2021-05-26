package com.coldfier.mynutrition3.cacheroom

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cache_table")
data class Food(

    @PrimaryKey
    val foodId: String,

    val label: String,

    @Embedded
    val nutrients: Nutrients,

    val category: String,

    val categoryLabel: String,

    val image: String
)

data class Nutrients(

    val calories: Double,

    val protein: Double,

    val fat: Double,

    val carb: Double
)