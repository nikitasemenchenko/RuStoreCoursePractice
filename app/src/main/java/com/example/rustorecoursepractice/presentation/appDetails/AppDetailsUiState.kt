package com.example.rustorecoursepractice.presentation.appDetails

import com.example.rustorecoursepractice.domain.AppDetails

sealed interface AppDetailsUiState {
    data object Loading : AppDetailsUiState
    data object Error : AppDetailsUiState
    data class Content(val app: AppDetails) : AppDetailsUiState
}