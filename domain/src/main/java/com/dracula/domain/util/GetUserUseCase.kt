package com.dracula.domain.util

import com.dracula.domain.entity.User
import com.dracula.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetUserUseCase(
    private val dispatcher: CoroutineDispatcher,
    private val userRepository: UserRepository
) : AbstractUseCase<GetUserUseCase.Request, GetUserUseCase.Response>(dispatcher) {

    data class Request(val userId: Long) : AbstractUseCase.Request
    data class Response(val user: User) : AbstractUseCase.Response

    override fun process(request: Request): Flow<Response> {
        return userRepository.getUserById(request.userId)
            .map {
                Response(user = it)
            }
    }
}