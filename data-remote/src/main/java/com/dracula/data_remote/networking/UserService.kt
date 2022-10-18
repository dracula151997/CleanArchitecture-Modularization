package com.dracula.data_remote.networking

import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("/users")
    suspend fun getUsers(): List<UserDto>

    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Long): UserDto
}