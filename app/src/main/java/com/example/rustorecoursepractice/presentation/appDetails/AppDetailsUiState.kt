package com.example.rustorecoursepractice.presentation.appDetails

import com.example.rustorecoursepractice.domain.App

sealed interface AppDetailsUiState {
    data object Loading : AppDetailsUiState
    data object Error : AppDetailsUiState
    data class Content(val app: App) : AppDetailsUiState
}