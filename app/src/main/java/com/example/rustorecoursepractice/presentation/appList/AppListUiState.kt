package com.example.rustorecoursepractice.presentation.appList

import androidx.annotation.StringRes
import com.example.rustorecoursepractice.domain.App

sealed interface AppListUiState {
    data object Loading: AppListUiState
    data object Error: AppListUiState
    data class Content(val appList: List<App>) : AppListUiState
}

sealed class AppListEvent{
    data class ShowSnackBar(@StringRes val textId: Int): AppListEvent()
}