package com.dracula.presentation_common.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun <T : Any> UiStateScreen(state: UiState<T>, onSuccess: @Composable (T) -> Unit) {
    when (state) {
        is UiState.Error -> ErrorItem(state.errorMessage)
        UiState.Loading -> LoadingItem()
        is UiState.Success -> onSuccess(state.data)
    }
}

@Composable
fun ErrorItem(errorMessage: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Snackbar {
            Text(errorMessage)
        }
    }
}

@Composable
fun LoadingItem(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}
