package com.example.rustorecoursepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.rustorecoursepractice.data.AppMapper
import com.example.rustorecoursepractice.data.AppsApi
import com.example.rustorecoursepractice.domain.AppsRepository
import com.example.rustorecoursepractice.presentation.navigation.NavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController)
        }
    }
}