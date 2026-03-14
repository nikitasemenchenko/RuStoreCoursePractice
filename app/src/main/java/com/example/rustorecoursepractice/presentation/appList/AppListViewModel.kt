package com.example.rustorecoursepractice.presentation.appList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rustorecoursepractice.model.Datasource
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

    init {
        loadContent()
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.send(SnackBarEvent.SnackBar("Клик на лого"))
        }
    }

    fun loadContent() {
        val apps = getApps()
        _uiState.value = AppListUiState.Content(apps)
    }

    fun getApps() = Datasource.getApps()
}