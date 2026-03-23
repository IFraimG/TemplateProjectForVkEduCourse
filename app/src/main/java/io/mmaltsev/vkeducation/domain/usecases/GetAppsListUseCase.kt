package io.mmaltsev.vkeducation.domain.usecases

import io.mmaltsev.vkeducation.domain.entities.App
import io.mmaltsev.vkeducation.domain.entities.AppShortInfo

interface GetAppsListUseCase {
    suspend operator fun invoke(): List<AppShortInfo>

}