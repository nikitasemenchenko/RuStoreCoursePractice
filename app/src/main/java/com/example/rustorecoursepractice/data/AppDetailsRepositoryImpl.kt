package com.example.rustorecoursepractice.data

import com.example.rustorecoursepractice.data.local.AppDetailsDao
import com.example.rustorecoursepractice.data.local.AppDetailsEntityMapper
import com.example.rustorecoursepractice.domain.AppDetails
import com.example.rustorecoursepractice.domain.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val api: AppsApi,
    private val mapper: AppDetailsMapper,
    private val dao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper,
) : AppDetailsRepository{

    override fun getAppById(id: String): Flow<AppDetails> =
        dao.getAppDetails(id).map { entity ->
            if(entity != null){
                entityMapper.toDomain(entity)
            }
            else {
                val appDto = api.getAppById(id)
                val appDomain = mapper.toDomain(appDto)
                val ent = entityMapper.toEntity(appDomain)
                withContext(Dispatchers.IO) {
                    dao.insertAppDetails(ent)
                }
                appDomain
            }
        }

    override suspend fun toggleWishlist(id: String) {
        val currentEntity = dao.getAppDetails(id).firstOrNull()
        currentEntity?.let {
            dao.updateWishlistStatus(id, !it.isInWishlist)
        }
    }
}