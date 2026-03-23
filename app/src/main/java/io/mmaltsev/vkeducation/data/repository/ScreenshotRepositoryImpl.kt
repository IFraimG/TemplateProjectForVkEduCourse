package io.mmaltsev.vkeducation.data.repository

import io.mmaltsev.vkeducation.data.api.ScreenshotAPI
import io.mmaltsev.vkeducation.data.mappers.ScreenshotMapper
import io.mmaltsev.vkeducation.domain.entities.Screenshot
import io.mmaltsev.vkeducation.domain.repository.ScreenshotRepository

class ScreenshotRepositoryImpl(
    private val screenshotAPI: ScreenshotAPI,
    private val screenshotMapper: ScreenshotMapper
): ScreenshotRepository {

    override suspend fun getScreenshotsListByAppId(appID: Int): List<Screenshot> {
        val screenshots = screenshotAPI.getScreenshotsByAppID()
        val screenshotsResult = screenshots.map { screenshotMapper.toDomain(it) }

        return screenshotsResult
    }
}