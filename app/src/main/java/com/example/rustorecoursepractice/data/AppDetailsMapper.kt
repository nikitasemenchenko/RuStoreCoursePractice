package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.AppDetails
import javax.inject.Inject

class AppDetailsMapper @Inject constructor() {
    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        category = dto.category,
        iconUrl = dto.iconUrl,
        description = dto.description,
        developer = dto.developer,
        ageRating = dto.ageRating,
        size = dto.size,
        screenshotUrlList = dto.screenshotUrlList
    )
}