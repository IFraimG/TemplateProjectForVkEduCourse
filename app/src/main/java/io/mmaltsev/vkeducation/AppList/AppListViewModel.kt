package io.mmaltsev.vkeducation.AppList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.mmaltsev.vkeducation.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppListViewModel(): ViewModel() {
    private val _state = MutableStateFlow(AppListState())
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = Channel<AppListScreenEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    fun showIconInfo(companyInfo: CompanyInfo) {
        viewModelScope.launch {
            _events.send(AppListScreenEvent.ShowSnackbar(companyInfo.title))
        }
    }
}