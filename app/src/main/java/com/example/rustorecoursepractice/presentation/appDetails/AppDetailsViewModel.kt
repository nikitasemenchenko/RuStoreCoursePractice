package com.example.rustorecoursepractice.presentation.appDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rustorecoursepractice.data.AppDetailsRepositoryImpl
import com.example.rustorecoursepractice.data.AppMapper
import com.example.rustorecoursepractice.data.AppsApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<AppDetailsUiState>(AppDetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    val appDetailsRepo = AppDetailsRepositoryImpl(
        api = AppsApi(),
        mapper = AppMapper()
    )

    fun loadApp(id: Int) {
        runCatching {
            viewModelScope.launch {
                _uiState.value = AppDetailsUiState.Loading
                val app = appDetailsRepo.getAppById(id)
                _uiState.value = AppDetailsUiState.Content(app)
            }
        }.onFailure {
            _uiState.value = AppDetailsUiState.Error
        }
    }
}