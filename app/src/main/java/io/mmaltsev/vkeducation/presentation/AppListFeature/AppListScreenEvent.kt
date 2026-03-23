package io.mmaltsev.vkeducation.presentation.AppListFeature

sealed interface AppListScreenEvent {

    data class ShowSnackbar(val message: String): AppListScreenEvent
}