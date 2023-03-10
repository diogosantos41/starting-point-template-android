package com.dscoding.startingpoint.ui.screens.second

import androidx.lifecycle.viewModelScope
import com.dscoding.startingpoint.common.Result
import com.dscoding.startingpoint.domain.model.Product
import com.dscoding.startingpoint.domain.repository.ApiRepository
import com.dscoding.startingpoint.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

data class SecondScreenState(
    val products: List<Product>,
    val isLoading: Boolean
)

@HiltViewModel
class SecondScreenViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    BaseViewModel<SecondScreenState>() {

    private var getProductsJob: Job? = null

    override fun initialState(): SecondScreenState {
        return SecondScreenState(
            products = emptyList(),
            isLoading = true
        )
    }

    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsJob?.cancel()
        getProductsJob = apiRepository.getProducts().onEach { productResource ->
            when (productResource) {
                is Result.Loading -> updateState(
                    uiState.value.copy(
                        isLoading = true
                    )
                )
                is Result.Success -> updateState(
                    uiState.value.copy(
                        products = productResource.data ?: emptyList(),
                        isLoading = false
                    )
                )
                is Result.Error -> updateState(
                    uiState.value.copy(
                        isLoading = false
                    )
                )
            }
        }.launchIn(viewModelScope)
    }
}


