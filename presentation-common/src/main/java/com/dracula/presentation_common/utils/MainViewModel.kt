package com.dracula.presentation_common.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class MainViewModel<T : Any, State : UiState<T>, Action : UiAction, Event : UiEvent> :
    ViewModel() {

    private val _uiState: MutableStateFlow<State> by lazy { MutableStateFlow(initState()) }
    val uiState = _uiState.asStateFlow()

    private val actionFlow: MutableSharedFlow<Action> = MutableSharedFlow()

    private val _event = Channel<Event>()
    val event = _event.receiveAsFlow()

    init {
        viewModelScope.launch {
            actionFlow.collect {
                handleAction(it)
            }
        }
    }

    fun submitAction(action: Action) {
        viewModelScope.launch { actionFlow.emit(action) }
    }

    fun submitState(state: State) {
        viewModelScope.launch {
            _uiState.value = state
        }
    }

    fun submitEvent(event: Event) {
        viewModelScope.launch {
            _event.send(event)
        }
    }

    abstract fun handleAction(it: Action)

    abstract fun initState(): State


}