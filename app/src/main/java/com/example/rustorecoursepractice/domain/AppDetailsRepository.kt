package com.example.rustorecoursepractice.domain

import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    fun getAppById(id: String): Flow<AppDetails>
    suspend fun toggleWishlist(id: String)
}