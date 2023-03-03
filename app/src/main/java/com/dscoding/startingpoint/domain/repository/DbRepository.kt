package com.dscoding.startingpoint.domain.repository

import com.dscoding.startingpoint.domain.model.SomeItem
import kotlinx.coroutines.flow.Flow

interface DbRepository {

    fun getItems(): Flow<List<SomeItem>>

    suspend fun getItemById(id: Int): SomeItem?

    suspend fun insertItem(item: SomeItem)

    suspend fun deleteItem(item: SomeItem)
}