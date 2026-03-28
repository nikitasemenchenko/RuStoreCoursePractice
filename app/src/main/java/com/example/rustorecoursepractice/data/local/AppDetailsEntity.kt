package com.example.rustorecoursepractice.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_details")
data class AppDetailsEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val developer: String,
    val category: String,
    val ageRating: Int,
    val size: Double,
    val iconUrl: String,
    val screenshots: List<String> = emptyList(),
    val description: String,
    val lastUpdated: Long = System.currentTimeMillis()
)