package com.dscoding.startingpoint.ui.productlist

import com.dscoding.startingpoint.domain.model.Product

data class ProductListState(
    val products: List<Product>,
    val isLoading: Boolean
)