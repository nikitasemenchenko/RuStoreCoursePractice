package com.example.rustorecoursepractice.presentation.appList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rustorecoursepractice.domain.GetAppListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val getAppListUseCase: GetAppListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<AppListUiState>(AppListUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _events = Channel<SnackBarEvent>()
    val events = _events.receiveAsFlow()

    init {
        loadContent()
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.send(SnackBarEvent.SnackBar("Клик на лого"))
        }
    }

    fun loadContent() {
        viewModelScope.launch {
            runCatching {
                _uiState.value = AppListUiState.Loading
                getAppListUseCase()
            }.onSuccess { apps ->
                _uiState.value = AppListUiState.Content(apps)
            }.onFailure {
                _uiState.value = AppListUiState.Error
            }
        }
    }

}