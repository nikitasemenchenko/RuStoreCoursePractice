package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.data.local.AppDetailsDao
import com.example.rustorecoursepractice.data.local.AppDetailsEntityMapper
import com.example.rustorecoursepractice.domain.AppDetails
import com.example.rustorecoursepractice.domain.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val api: AppsApi,
    private val mapper: AppDetailsMapper,
    private val dao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper,
) : AppDetailsRepository{

    override suspend fun getAppById(id: String): AppDetails {
        val appEntity = dao.getAppDetails(id).firstOrNull()
        if(appEntity != null){
            return entityMapper.toDomain(appEntity)
        }
        else {
            val appDto = api.getAppById(id)
            val appDomain = mapper.toDomain(appDto)
            val entity = entityMapper.toEntity(appDomain)
            withContext(Dispatchers.IO) {
                dao.insertAppDetails(entity)
            }
            return appDomain
        }
    }
}