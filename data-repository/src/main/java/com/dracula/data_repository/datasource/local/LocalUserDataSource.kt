package com.dracula.data_repository.datasource.local

import com.dracula.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {
    fun getUsers(): Flow<List<User>>
    suspend fun addUsers(users: List<User>)
    suspend fun addUser(user: User)
}