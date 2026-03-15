package com.example.rustorecoursepractice.presentation.appDetails

import androidx.lifecycle.ViewModel
import com.example.rustorecoursepractice.model.Datasource.getApps
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppDetailsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<AppDetailsUiState>(AppDetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun loadApp(id: Int) {
        val app = getAppById(id)
        _uiState.value = AppDetailsUiState.Content(app)
    }

    fun getAppById(id: Int): App {
        val apps = getApps()
        for (app in apps) {
            if (app.id == id) {
                return app
            }
        }
        return apps[0]
    }
}