package com.dracula.data_local.di

import com.dracula.data_local.source.LocalUserDataSourceImpl
import com.dracula.data_repository.datasource.local.LocalUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {
    @Binds
    abstract fun bindLocalUserDataSource(localUserDataSourceImpl: LocalUserDataSourceImpl): LocalUserDataSource
}