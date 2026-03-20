package com.example.rustorecoursepractice.presentation.appList

import com.example.rustorecoursepractice.domain.App

sealed interface AppListUiState {
    data object Loading: AppListUiState
    data object Error: AppListUiState
    data class Content(val appList: List<App>) : AppListUiState
}

sealed class SnackBarEvent{
    data class SnackBar(val text: String): SnackBarEvent()
}