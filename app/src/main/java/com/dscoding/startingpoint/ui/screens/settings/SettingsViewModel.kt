package com.dscoding.startingpoint.ui.screens.settings

import com.dscoding.startingpoint.domain.model.Product
import com.dscoding.startingpoint.domain.repository.ApiRepository
import com.dscoding.startingpoint.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class SettingsState(
    val products: List<Product>,
    val isLoading: Boolean
)

@HiltViewModel
class SettingsViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    BaseViewModel<SettingsState>() {
    override fun initialState(): SettingsState {
        return SettingsState(
            products = emptyList(),
            isLoading = true
        )
    }
}