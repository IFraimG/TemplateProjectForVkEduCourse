package io.mmaltsev.vkeducation.presentation.TemplateFeature

import io.mmaltsev.vkeducation.domain.entities.App
import io.mmaltsev.vkeducation.domain.entities.Category
import io.mmaltsev.vkeducation.presentation.utils.LoaderStatus

data class AppDetailsState(
    val appInfo: App = App(
        name = "",
        developer = "",
        category = Category.APP,
        ageRating = 0,
        size = 0f,
        iconUrl = "",
        screenshotUrlList = listOf(),
        description = "",
        id = 0
    ),

    val loaderStatus: LoaderStatus = LoaderStatus.LOADING
)