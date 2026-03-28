package com.example.rustorecoursepractice.presentation.appList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AppListScreen(
    onAppClick: (String) -> Unit,
    vm: AppListViewModel = hiltViewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val uiState by vm.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.events.collect { event ->
            if(event is SnackBarEvent.SnackBar){
                snackbarHostState.showSnackbar(message = event.text)
            }
        }
    }
    Scaffold(
        topBar = {
            MainHeader(
                onClick = {
                    vm.onLogoClick()
                }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { contentPadding ->
        when(val currentState = uiState){
            is AppListUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator()
                }
            }
            is AppListUiState.Content -> {
                Box(modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxSize()) {
                    LazyColumn {
                        items(currentState.appList) { app ->
                            AppCard(app, onAppClick)
                        }
                    }
                }
            }
            AppListUiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text("Ошибка")
                }
            }
        }
    }
}