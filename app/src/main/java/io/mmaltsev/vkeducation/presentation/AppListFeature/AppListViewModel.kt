package io.mmaltsev.vkeducation.presentation.AppListFeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.mmaltsev.vkeducation.domain.entities.AppShortInfo
import io.mmaltsev.vkeducation.domain.usecases.GetAppsListUseCase
import io.mmaltsev.vkeducation.presentation.utils.LoaderStatus
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppListViewModel(
    private val getAppsListUseCase: GetAppsListUseCase
): ViewModel() {
    private val _state = MutableStateFlow(AppListState())
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = Channel<AppListScreenEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getAppsList()
    }

    fun showIconInfo(appShortInfo: AppShortInfo) {
        viewModelScope.launch {
            _events.send(AppListScreenEvent.ShowSnackbar(appShortInfo.title))
        }
    }

    fun getAppsList() {
        viewModelScope.launch {
            _state.update {
                it.copy(loaderStatus = LoaderStatus.LOADING)
            }

            val appsList = getAppsListUseCase.invoke()
            _state.update {
                it.copy(
                    listCompanies = appsList,
                    loaderStatus = LoaderStatus.SUCCESS
                )
            }
        }
    }
}