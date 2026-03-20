package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.Category

data class AppDetailsDto(
    val id: Int,
    val name: String,
    val developer: String,
    val smallDescription: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
)