package io.mmaltsev.vkeducation.data.repository

import io.mmaltsev.vkeducation.data.api.AppAPI
import io.mmaltsev.vkeducation.data.mappers.AppInfoMapper
import io.mmaltsev.vkeducation.data.mappers.AppShortMapper
import io.mmaltsev.vkeducation.domain.entities.App
import io.mmaltsev.vkeducation.domain.entities.AppShortInfo
import io.mmaltsev.vkeducation.domain.repository.AppRepository

class AppRepositoryImpl(
    private val appShortMapper: AppShortMapper,
    private val appMapper: AppInfoMapper,
    private val api: AppAPI
): AppRepository {

    override suspend fun getAppsInfo(): List<AppShortInfo> {
        val appsListDTO = api.getApps()
        val appsListResult = appsListDTO.map { appShortMapper.toDomain(it) }

        return appsListResult
    }

    override suspend fun getAppByID(id: Int): App {
        val appInfoDTO = api.getAppInfo(id)
        val appInfoResult = appMapper.toDomain(appInfoDTO)

        return appInfoResult
    }
}