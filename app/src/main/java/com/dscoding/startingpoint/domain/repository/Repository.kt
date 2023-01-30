package com.dscoding.startingpoint.domain.repository

import com.dscoding.startingpoint.domain.model.Product
import com.dscoding.startingpoint.common.Result
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getProducts(): Flow<Result<List<Product>>>

}