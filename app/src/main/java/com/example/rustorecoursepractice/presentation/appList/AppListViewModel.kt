package com.example.rustorecoursepractice.presentation.appList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rustorecoursepractice.data.AppsRepositoryImpl
import com.example.rustorecoursepractice.data.AppMapper
import com.example.rustorecoursepractice.data.AppsApi
import com.example.rustorecoursepractice.domain.GetAppListUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<AppListUiState>(AppListUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _events = Channel<SnackBarEvent>()
    val events = _events.receiveAsFlow()

    val appsRepo = AppsRepositoryImpl(
        api = AppsApi(),
        mapper = AppMapper()
    )

    val getAppListUseCase = GetAppListUseCase(
        appsRepo
    )

    init {
        loadContent()
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.send(SnackBarEvent.SnackBar("Клик на лого"))
        }
    }

    fun loadContent() {
        runCatching {
            viewModelScope.launch {
                _uiState.value = AppListUiState.Loading
                val apps = getAppListUseCase()
                _uiState.value = AppListUiState.Content(apps)
            }
        }.onFailure {
            _uiState.value = AppListUiState.Error
        }
    }

}