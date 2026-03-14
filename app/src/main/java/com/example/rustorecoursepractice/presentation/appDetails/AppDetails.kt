package com.example.rustorecoursepractice.presentation.appDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppDetails(
    appId: Int,
    onBackClick: () -> Unit
){
    val vm: AppDetailsViewModel = viewModel()
    val uiState by vm.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(appId) {
        vm.loadApp(appId)
    }

    when(val currentState = uiState){
        is AppDetailsUiState.Content -> {
            val app = currentState.app
            AppDetailsScreen(app = app, onBackClick = onBackClick)
        }
        AppDetailsUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text("Ошибка")
            }
        }
        AppDetailsUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
    }
}