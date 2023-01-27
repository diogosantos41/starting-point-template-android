package com.dscoding.startingpoint.data.api

import com.dscoding.startingpoint.data.model.ProductListDto
import retrofit2.http.GET

interface SpApi {

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }

    @GET("products/")
    suspend fun getProducts(): ProductListDto
}


