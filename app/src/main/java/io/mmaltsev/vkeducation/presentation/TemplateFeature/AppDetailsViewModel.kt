package io.mmaltsev.vkeducation.presentation.TemplateFeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.mmaltsev.vkeducation.domain.usecases.GetAppInfoUseCase
import io.mmaltsev.vkeducation.presentation.utils.LoaderStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppDetailsViewModel(
    private val getAppInfoUseCase: GetAppInfoUseCase
): ViewModel() {

    private val _state = MutableStateFlow(AppDetailsState())
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    init {
        getAppInfo(7)
    }

    fun getAppInfo(appID: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(loaderStatus = LoaderStatus.LOADING)
            }

            val result = getAppInfoUseCase(appID)
            _state.update {
                it.copy(
                    appInfo = result,
                    loaderStatus = LoaderStatus.SUCCESS
                )
            }
        }
    }
}