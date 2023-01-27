package com.dscoding.startingpoint.data.model

import com.dscoding.startingpoint.domain.model.Product


data class ProductDto(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String
)

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        title = title,
        price = price,
        thumbnail = thumbnail
    )
}
