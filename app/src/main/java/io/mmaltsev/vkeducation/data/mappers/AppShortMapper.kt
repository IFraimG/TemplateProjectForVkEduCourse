package io.mmaltsev.vkeducation.data.mappers

import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.data.dto.AppShortInfoDto
import io.mmaltsev.vkeducation.domain.entities.AppShortInfo

class AppShortMapper {

    private fun chooseDrawable(id: Int): Int = when (id) {
        1 -> R.drawable.sber
        2 -> R.drawable.yandexbrowser
        3 -> R.drawable.mailrulogo
        4 -> R.drawable.navigator
        5 -> R.drawable.mtc
        6 -> R.drawable.alisa
        else -> R.drawable.mtc // temporarily default
    }

    fun toDomain(dto: AppShortInfoDto) = AppShortInfo(
        title = dto.title,
        description = dto.description,
        category = dto.category,
        id = dto.id,
        drawableLogoId = chooseDrawable(dto.id),
    )
}