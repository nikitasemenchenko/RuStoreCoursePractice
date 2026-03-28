package com.example.rustorecoursepractice.domain

interface AppDetailsRepository {
    suspend fun getAppById(id: String): AppDetails
}