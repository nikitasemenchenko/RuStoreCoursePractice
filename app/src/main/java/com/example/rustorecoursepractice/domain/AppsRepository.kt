package com.example.rustorecoursepractice.domain

interface AppsRepository {
    suspend fun getApps(): List<App>
}