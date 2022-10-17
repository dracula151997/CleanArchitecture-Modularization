package com.dracula.domain.repository

import com.dracula.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<List<User>>

    fun getUserById(id: Long): Flow<User>
}