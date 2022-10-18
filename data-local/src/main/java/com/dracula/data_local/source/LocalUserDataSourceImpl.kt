package com.dracula.data_local.source

import com.dracula.data_local.db.user.UserDao
import com.dracula.data_local.db.user.UserEntity
import com.dracula.data_repository.datasource.local.LocalUserDataSource
import com.dracula.domain.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserDataSourceImpl @Inject constructor(
    private val userDao: UserDao
) : LocalUserDataSource {
    override fun getUsers(): Flow<List<User>> = userDao.getUsers().map { users ->
        users.map {
            User(it.id, it.name, it.username, it.email)
        }
    }

    override suspend fun addUsers(users: List<User>) =
        userDao.insertUsers(users = users.map { UserEntity(it.id, it.name, it.username, it.email) })

    override suspend fun addUser(user: User) =
        userDao.insertUser(UserEntity(user.id, user.name, user.username, user.email))
}