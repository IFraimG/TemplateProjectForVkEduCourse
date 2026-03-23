package io.mmaltsev.vkeducation.presentation.AppListFeature

import io.mmaltsev.vkeducation.domain.entities.AppShortInfo
import io.mmaltsev.vkeducation.presentation.utils.LoaderStatus

data class AppListState(
    val listCompanies: List<AppShortInfo> = listOf(),
    val loaderStatus: LoaderStatus = LoaderStatus.LOADING
)