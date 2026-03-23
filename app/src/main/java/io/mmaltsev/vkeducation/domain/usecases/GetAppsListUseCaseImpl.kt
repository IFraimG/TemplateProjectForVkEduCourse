package io.mmaltsev.vkeducation.domain.usecases

import io.mmaltsev.vkeducation.domain.entities.AppShortInfo
import io.mmaltsev.vkeducation.domain.repository.AppRepository

class GetAppsListUseCaseImpl(
    private val appRepository: AppRepository
): GetAppsListUseCase {

    override suspend operator fun invoke(): List<AppShortInfo> {
        return appRepository.getAppsInfo()
    }
}