package com.dracula.data_repository.datasource.remote

import com.dracula.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface RemoteUserDataSource {
    fun getUsers(): Flow<List<User>>

    fun getUserById(id: Long): Flow<User>
}