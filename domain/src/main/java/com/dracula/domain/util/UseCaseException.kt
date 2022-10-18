package com.dracula.domain.util

sealed class UseCaseException(cause: Throwable) : Throwable(cause) {
    class UserException(cause: Throwable) : UseCaseException(cause)
}