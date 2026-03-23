package io.mmaltsev.vkeducation.domain.usecases

import io.mmaltsev.vkeducation.domain.entities.App

interface GetAppInfoUseCase {
    suspend operator fun invoke(appID: Int): App
}