package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.App
import javax.inject.Inject

class AppMapper @Inject constructor() {
    fun toDomain(dto: AppDetailsDto): App = App(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        smallDescription = dto.smallDescription,
        category = dto.category,
        ageRating = dto.ageRating,
        size = dto.size,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshotUrlList,
        description = dto.description
    )
}