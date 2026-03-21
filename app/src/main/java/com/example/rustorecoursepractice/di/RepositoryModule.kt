package com.example.rustorecoursepractice.di

import com.example.rustorecoursepractice.data.AppDetailsRepositoryImpl
import com.example.rustorecoursepractice.data.AppsRepositoryImpl
import com.example.rustorecoursepractice.domain.AppDetailsRepository
import com.example.rustorecoursepractice.domain.AppsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun getAppDetailsRepository(
        impl: AppDetailsRepositoryImpl
    ): AppDetailsRepository

    @Binds
    abstract fun getAppsRepository(
        impl: AppsRepositoryImpl
    ): AppsRepository
}