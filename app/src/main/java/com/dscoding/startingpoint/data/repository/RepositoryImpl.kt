package com.dscoding.startingpoint.data.repository

import com.dscoding.startingpoint.data.api.SpApi
import com.dscoding.startingpoint.data.model.toProduct
import com.dscoding.startingpoint.domain.model.Product
import com.dscoding.startingpoint.domain.repository.Repository
import com.dscoding.startingpoint.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(private val api: SpApi) : Repository {
    override fun getProducts(): Flow<Result<List<Product>>> =
        flow {
            emit(Result.Loading())
            try {
                val products = api.getProducts().products.map { it.toProduct() }
                emit(Result.Success(products))
            } catch (throwable: Throwable) {
                emit(Result.Error(throwable))
            }
        }
}