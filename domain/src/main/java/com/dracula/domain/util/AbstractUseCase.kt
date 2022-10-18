package com.dracula.domain.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

abstract class AbstractUseCase<Request : AbstractUseCase.Request, Response : AbstractUseCase.Response>(
    private val dispatcher: CoroutineDispatcher
) {

    fun execute(request: Request) = process(request)
        .map { NetworkResult.Success(it) as NetworkResult<Response> }
        .flowOn(dispatcher)
        .catch {
            emit(NetworkResult.Error(it))
        }

    internal abstract fun process(request: Request): Flow<Response>

    interface Request
    interface Response
}