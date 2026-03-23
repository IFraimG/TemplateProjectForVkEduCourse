package io.mmaltsev.vkeducation.data.mappers

import io.mmaltsev.vkeducation.data.dto.AppInfoDto
import io.mmaltsev.vkeducation.domain.entities.App

class AppInfoMapper {

    fun toDomain(appInfoDto: AppInfoDto) = App(
        name = appInfoDto.name,
        id = appInfoDto.id,
        developer = appInfoDto.developer,
        category = appInfoDto.category,
        ageRating = appInfoDto.ageRating,
        size = appInfoDto.size,
        iconUrl = appInfoDto.iconUrl,
        description = appInfoDto.description,
        screenshotUrlList = listOf()
    )
}