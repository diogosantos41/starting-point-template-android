package com.dscoding.startingpoint.ui.main

import androidx.lifecycle.viewModelScope
import com.dscoding.startingpoint.domain.repository.Repository
import com.dscoding.startingpoint.ui.base.BaseViewModel
import com.dscoding.startingpoint.ui.navigation.TOP_LEVEL_DESTINATIONS
import com.dscoding.startingpoint.ui.navigation.TopLevelDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUIState(
    val currentTopLevelDestination: TopLevelDestination,
    val showLoading: Boolean,
    val showBottomBar: Boolean
)

sealed interface UiEvent {
    data class NavigateTo(val destination: TopLevelDestination) : UiEvent
}

@HiltViewModel
class MainViewModel @Inject constructor() :
    BaseViewModel<MainUIState>() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    override fun initialState(): MainUIState {
        return MainUIState(
            currentTopLevelDestination = TOP_LEVEL_DESTINATIONS[0],
            showLoading = false,
            showBottomBar = false
        )
    }

    fun navigateTo(destination: TopLevelDestination) {
        updateState(
            uiState.value.copy(
                currentTopLevelDestination = destination,
                showBottomBar = true
            )
        )
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.NavigateTo(destination))
        }
    }

    fun onBoardingCompleted() {
        navigateTo(TOP_LEVEL_DESTINATIONS[0])
    }

    fun showLoading(showLoading: Boolean) {
        updateState(
            uiState.value.copy(
                showLoading = showLoading
            )
        )
    }
}