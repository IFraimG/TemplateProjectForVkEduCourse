package io.mmaltsev.vkeducation.data.mappers

import io.mmaltsev.vkeducation.data.dto.ScreenshotDto
import io.mmaltsev.vkeducation.domain.entities.Screenshot

class ScreenshotMapper {

    fun toDomain(screenShotDTO: ScreenshotDto): Screenshot = Screenshot(
        url = screenShotDTO.url,
        id = screenShotDTO.id
    )
}