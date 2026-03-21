package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.App
import com.example.rustorecoursepractice.domain.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val api: AppsApi,
    private val mapper: AppMapper
) : AppDetailsRepository{
    override suspend fun getAppById(id: Int): App {
        val apps = api.getApps()
        for (app in apps) {
            if (app.id == id) {
                return mapper.toDomain(app)
            }
        }
        return mapper.toDomain(apps[0])
    }
}