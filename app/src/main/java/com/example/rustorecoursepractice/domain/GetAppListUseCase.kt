package com.example.rustorecoursepractice.domain

class GetAppListUseCase(
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