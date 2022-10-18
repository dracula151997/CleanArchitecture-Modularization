package com.dracula.feature_user

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.dracula.domain.entity.User
import com.dracula.presentation_common.navigation.UserInput
import com.dracula.presentation_common.utils.UiStateScreen

@Composable
fun UserScreen(
    viewModel: UserViewModel,
    userInput: UserInput
) {
    viewModel.uiState.collectAsState().value.let { uiState ->
        UiStateScreen(uiState) { user ->
            UserItem(user)
        }
    }

    LaunchedEffect(userInput.userId) {
        viewModel.submitAction(UserUiAction.Load(userId = userInput.userId))
    }
}

@Composable
fun UserItem(it: User) {
    Column {
        Text(it.name)
        Text(it.email)
        Text(it.username)
    }
}
