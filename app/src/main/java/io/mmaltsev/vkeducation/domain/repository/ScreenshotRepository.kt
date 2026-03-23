package io.mmaltsev.vkeducation.domain.repository

import io.mmaltsev.vkeducation.domain.entities.Screenshot

interface ScreenshotRepository {

    suspend fun getScreenshotsListByAppId(appID: Int): List<Screenshot>
}