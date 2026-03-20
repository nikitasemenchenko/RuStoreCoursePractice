package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.App
import com.example.rustorecoursepractice.domain.AppsRepository

class AppsRepositoryImpl(
    private val api: AppsApi,
    private val mapper: AppMapper
): AppsRepository {
    override suspend fun getApps(): List<App> {
        val apps = api.getApps().map { mapper.toDomain(it) }
        return apps
    }
}