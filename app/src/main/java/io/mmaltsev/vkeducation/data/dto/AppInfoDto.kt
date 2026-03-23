package io.mmaltsev.vkeducation.data.dto

import io.mmaltsev.vkeducation.domain.entities.Category

data class AppInfoDto(
    val name: String,
    val id: Int,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val description: String
)