package com.coldfier.mynutrition3.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

//Main Json response
data class FoodResponse(
    @Json(name = "text")
    val name: String?,

    val hints: List<Hint>?,

    @Json(name = "_links")
    val nextPage: NextPageWrapper?
)

//Object-wrapper of "hints" field
data class Hint(val food: Food?)

//Object-wrapper of "_links" field
data class NextPageWrapper(val next: NextPage)

data class NextPage(
    val title: String?,
    val href: String?
)

data class Food(

    val foodId: String?,

    val label: String?,

    val nutrients: Nutrients?,

    val category: String?,

    val categoryLabel: String?,

    val image: String?
)

data class Nutrients(
    @Json(name = "ENERC_KCAL")
    val calories: Double?,

    @Json(name = "PROCNT")
    val protein: Double?,

    @Json(name = "FAT")
    val fat: Double?,

    @Json(name = "CHOCDF")
    val carb: Double?
)
