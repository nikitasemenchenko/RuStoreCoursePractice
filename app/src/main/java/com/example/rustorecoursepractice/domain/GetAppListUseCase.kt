package com.example.rustorecoursepractice.domain

import javax.inject.Inject

class GetAppListUseCase @Inject constructor(
    private val appsRepository: AppsRepository
) {
    suspend operator fun invoke():List<App>{
        val apps = appsRepository.getApps()

        //типо логика
        val flag = false
        if(flag){
            throw IllegalStateException()
        }
        return apps
    }
}