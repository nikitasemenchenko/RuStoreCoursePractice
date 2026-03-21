package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.domain.AppDetails
import com.example.rustorecoursepractice.domain.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val api: AppsApi,
    private val mapper: AppDetailsMapper
) : AppDetailsRepository{

    override suspend fun getAppById(id: String): AppDetails {
        val app = api.getAppById(id)
        return mapper.toDomain(app)
    }
}