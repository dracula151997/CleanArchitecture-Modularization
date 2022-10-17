package com.dracula.data_repository.repository

import com.dracula.data_repository.datasource.local.LocalUserDataSource
import com.dracula.data_repository.datasource.remote.RemoteUserDataSource
import com.dracula.domain.entity.User
import com.dracula.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class UserRepositoryImpl(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val localUserDataSource: LocalUserDataSource
) : UserRepository {
    override fun getAllUsers(): Flow<List<User>> {
        return remoteUserDataSource.getUsers()
            .onEach { localUserDataSource.addUsers(it) }
    }

    override fun getUserById(id: Long): Flow<User> {
        return remoteUserDataSource.getUserById(id)
            .onEach { localUserDataSource.addUser(it) }
    }
}