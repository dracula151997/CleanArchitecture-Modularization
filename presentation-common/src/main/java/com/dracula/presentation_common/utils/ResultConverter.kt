package com.dracula.presentation_common.utils

import com.dracula.domain.util.NetworkResult

abstract class ResultConverter<T : Any, R : Any> {
    fun convert(result: NetworkResult<T>): UiState<R> {
        return when (result) {
            is NetworkResult.Error -> UiState.Error(result.exception.localizedMessage.orEmpty())
            is NetworkResult.Success -> UiState.Success(convertSuccess(result.data))
        }
    }

    abstract fun convertSuccess(data: T): R
}