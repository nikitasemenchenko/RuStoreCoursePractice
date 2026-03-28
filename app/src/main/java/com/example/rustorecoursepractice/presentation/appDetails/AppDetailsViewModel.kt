package com.example.rustorecoursepractice.presentation.appDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.rustorecoursepractice.domain.AppDetailsRepository
import com.example.rustorecoursepractice.presentation.navigation.AppDetailsRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val appDetailsRepo: AppDetailsRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow<AppDetailsUiState>(AppDetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val appId: String = savedStateHandle.toRoute<AppDetailsRoute>().id

    init {
        loadApp(appId)
    }

    fun loadApp(id: String) {
        viewModelScope.launch {
            _uiState.value = AppDetailsUiState.Loading
            appDetailsRepo.getAppById(id)
                .catch {
                    _uiState.value = AppDetailsUiState.Error
                }
                .collect { appDetails ->
                    _uiState.value = AppDetailsUiState.Content(appDetails)
                }
        }
    }

    fun toggleWishlist() {
        viewModelScope.launch {
            appDetailsRepo.toggleWishlist(appId)
        }
    }
}