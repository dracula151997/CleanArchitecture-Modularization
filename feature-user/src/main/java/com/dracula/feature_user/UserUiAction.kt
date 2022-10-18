package com.dracula.feature_user

import com.dracula.presentation_common.utils.UiAction

sealed class UserUiAction : UiAction {
    data class Load(val userId: Long) : UserUiAction()
}