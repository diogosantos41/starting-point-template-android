package com.dscoding.startingpoint.data.repository

import com.dscoding.startingpoint.data.data_source.ItemDao
import com.dscoding.startingpoint.domain.model.SomeItem
import com.dscoding.startingpoint.domain.repository.DbRepository
import kotlinx.coroutines.flow.Flow

class DbRepositoryImpl(
    private val dao: ItemDao
) : DbRepository {
    override fun getItems(): Flow<List<SomeItem>> {
        return dao.getItems()
    }

    override suspend fun getItemById(id: Int): SomeItem? {
        return dao.getItemById(id)
    }

    override suspend fun insertItem(item: SomeItem) {
        return dao.insertItem(item)
    }

    override suspend fun deleteItem(item: SomeItem) {
        return dao.deleteItem(item)
    }
}