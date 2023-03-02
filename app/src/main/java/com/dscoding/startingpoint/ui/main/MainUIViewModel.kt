package com.dscoding.startingpoint.ui.main

import com.dscoding.startingpoint.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class MainUIState(
    val showLoading: Boolean,
    val showBottomBar: Boolean
)

@HiltViewModel
class MainUIViewModel @Inject constructor() :
    BaseViewModel<MainUIState>() {

    override fun initialState(): MainUIState {
        return MainUIState(
            showLoading = false,
            showBottomBar = false
        )
    }
}