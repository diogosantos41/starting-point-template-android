package com.dscoding.startingpoint.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dscoding.startingpoint.domain.model.SomeItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM ${SomeItem.TABLE_NAME}")
    fun getItems(): Flow<List<SomeItem>>

    @Query("SELECT * FROM ${SomeItem.TABLE_NAME} WHERE id = :id")
    suspend fun getItemById(id: Int): SomeItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: SomeItem)

    @Delete
    suspend fun deleteItem(item: SomeItem)
}