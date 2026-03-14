package com.example.rustorecoursepractice.appList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rustorecoursepractice.appDetails.App

@Composable
fun AppListScreen(
    apps: List<App>,
    onAppClick: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            MainHeader()
        }
    ) { contentPadding ->
        Box(modifier = Modifier
            .padding(contentPadding)
            .fillMaxSize()) {
            LazyColumn {
                items(apps) { app ->
                    AppCard(app, onAppClick)
                }
            }
        }
    }
}