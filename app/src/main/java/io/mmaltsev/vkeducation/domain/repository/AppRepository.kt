package io.mmaltsev.vkeducation.domain.repository

import io.mmaltsev.vkeducation.domain.entities.App
import io.mmaltsev.vkeducation.domain.entities.AppShortInfo

interface AppRepository {
    suspend fun getAppsInfo(): List<AppShortInfo>

    suspend fun getAppByID(id: Int): App
}