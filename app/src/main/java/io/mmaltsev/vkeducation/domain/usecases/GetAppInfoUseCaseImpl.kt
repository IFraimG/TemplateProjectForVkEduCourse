package io.mmaltsev.vkeducation.domain.usecases

import io.mmaltsev.vkeducation.domain.entities.App
import io.mmaltsev.vkeducation.domain.repository.AppRepository
import io.mmaltsev.vkeducation.domain.repository.ScreenshotRepository

class GetAppInfoUseCaseImpl(
    private val appRepository: AppRepository,
    private val screenRepository: ScreenshotRepository,
): GetAppInfoUseCase {

    override suspend operator fun invoke(appID: Int): App {
        val app: App = appRepository.getAppByID(appID)
        val screens = screenRepository.getScreenshotsListByAppId(appID)
        val screensResult = screens.map { it -> it.url }

        return app.copy(screenshotUrlList = screensResult)
    }
}