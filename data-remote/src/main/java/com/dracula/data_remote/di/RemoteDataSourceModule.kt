package com.dracula.data_remote.di

import com.dracula.data_remote.source.RemoteUserDataSourceImpl
import com.dracula.data_repository.datasource.remote.RemoteUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun bindUserDataSource(userDataSourceImple: RemoteUserDataSourceImpl): RemoteUserDataSource
}