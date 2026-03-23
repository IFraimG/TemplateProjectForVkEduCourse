package io.mmaltsev.vkeducation.domain.entities

data class AppShortInfo(
    val title: String,
    val description: String,
    val category: String,
    val drawableLogoId: Int,
    val id: Int
)