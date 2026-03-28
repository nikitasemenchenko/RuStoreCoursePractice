package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.App
import com.example.rustorecoursepractice.domain.AppsRepository
import javax.inject.Inject

class AppsRepositoryImpl @Inject constructor(
    private val api: AppsApi,
    private val mapper: AppMapper
): AppsRepository {

    override suspend fun getApps(): List<App> {
        val apps = api.getApps().map { mapper.toDomain(it) }
        return apps
    }
}