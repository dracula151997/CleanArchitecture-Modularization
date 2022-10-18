package com.dracula.data_remote.source

import com.dracula.data_remote.networking.UserDto
import com.dracula.data_remote.networking.UserService
import com.dracula.data_repository.datasource.remote.RemoteUserDataSource
import com.dracula.domain.entity.User
import com.dracula.domain.util.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteUserDataSourceImpl @Inject constructor(
    private val userService: UserService
) : RemoteUserDataSource {
    override fun getUsers(): Flow<List<User>> = flow {
        emit(userService.getUsers())
    }.map { users ->
        users.map { convert(it) }
    }.catch {
        throw UseCaseException.UserException(it)
    }

    override fun getUserById(id: Long): Flow<User> = flow {
        emit(userService.getUser(id))
    }.map {
        convert(it)
    }.catch { throw UseCaseException.UserException(it) }

    private fun convert(userDto: UserDto) =
        User(userDto.id, userDto.name, userDto.username, userDto.email)

}