package com.dracula.feature_user

import com.dracula.domain.entity.User
import com.dracula.domain.util.GetUserUseCase
import com.dracula.presentation_common.utils.ResultConverter
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class UserResultConverter @Inject constructor() : ResultConverter<GetUserUseCase.Response, User>() {
    override fun convertSuccess(data: GetUserUseCase.Response): User {
        return data.user
    }
}