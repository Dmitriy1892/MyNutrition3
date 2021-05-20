package com.coldfier.mynutrition3.retrofit

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Hints(
    @field:Json(name = "text")
    val name: String?,

    @field:Json(name = "parsed")
    val parsed: List<Food>?,

    @field:Json(name = "hints")
    val hints: List<Food>?
)

data class Food(
    @field:Json(name = "foodId")
    val foodId: String?,

    @field:Json(name = "label")
    val label: String?,

    @field:Json(name = "nutrients")
    val nutrients: Nutrients?,

    @field:Json(name = "category")
    val category: String?,

    @field:Json(name = "categoryLabel")
    val string: String?,

    @field:Json(name = "image")
    val image: String?
)

data class Nutrients(
    @field:Json(name = "ENERC_KCAL")
    val calories: Double?,

    @field:Json(name = "PROCNT")
    val protein: Double?,

    @field:Json(name = "FAT")
    val fat: Double?,

    @field:Json(name = "CHOCDF")
    val carb: Double?
)
