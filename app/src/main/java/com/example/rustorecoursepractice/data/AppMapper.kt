package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.App
import javax.inject.Inject

class AppMapper @Inject constructor() {
    fun toDomain(dto: AppDto): App = App(
        id = dto.id,
        name = dto.name,
        category = dto.category,
        iconUrl = dto.iconUrl,
        description = dto.description
    )
}