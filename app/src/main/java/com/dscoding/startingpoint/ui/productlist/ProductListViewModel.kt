package com.dscoding.startingpoint.ui.productlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscoding.startingpoint.domain.repository.Repository
import com.dscoding.startingpoint.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    private val _state = mutableStateOf(ProductListState())
    val state: State<ProductListState> = _state

    private var getProductsJob: Job? = null

    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsJob?.cancel()
        getProductsJob = repository.getProducts()
            .onEach { productResource ->
                when (productResource) {
                    is Result.Loading ->
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    is Result.Success ->
                        _state.value = state.value.copy(
                            products = productResource.data ?: emptyList(),
                            isLoading = false
                        )
                    is Result.Error ->
                        _state.value = state.value.copy(
                            isLoading = false
                        )
                }
            }
            .launchIn(viewModelScope)
    }
}


