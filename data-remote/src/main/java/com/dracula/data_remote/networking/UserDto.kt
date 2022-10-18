package com.dracula.data_remote.networking

import com.squareup.moshi.Json

data class UserDto(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "username") val username: String,
    @Json(name = "email") val email: String
)