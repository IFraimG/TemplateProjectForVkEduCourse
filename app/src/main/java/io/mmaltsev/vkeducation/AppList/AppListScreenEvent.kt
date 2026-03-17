package io.mmaltsev.vkeducation.AppList

sealed interface AppListScreenEvent {

    data class ShowSnackbar(val message: String): AppListScreenEvent
}