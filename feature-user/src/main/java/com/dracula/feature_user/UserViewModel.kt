package com.dracula.feature_user

import androidx.lifecycle.viewModelScope
import com.dracula.domain.entity.User
import com.dracula.domain.util.GetUserUseCase
import com.dracula.presentation_common.utils.MainViewModel
import com.dracula.presentation_common.utils.UiEvent
import com.dracula.presentation_common.utils.UiState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userUseCase: GetUserUseCase,
    private val converter: UserResultConverter
) : MainViewModel<User, UiState<User>, UserUiAction, UiEvent>() {
    override fun handleAction(it: UserUiAction) {
        when (it) {
            is UserUiAction.Load -> loadUser(it.userId)
        }
    }

    private fun loadUser(userId: Long) {
        viewModelScope.launch {
            userUseCase.execute(GetUserUseCase.Request(userId))
                .map {
                    converter.convert(it)
                }.collect {
                    submitState(it)
                }
        }
    }

    override fun initState(): UiState<User> = UiState.Loading
}