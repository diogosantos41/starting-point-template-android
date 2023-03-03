package com.dscoding.startingpoint.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dscoding.startingpoint.domain.model.SomeItem

@Database(entities = [SomeItem::class], version = 1)

abstract class ItemDatabase : RoomDatabase() {
    abstract val itemDao: ItemDao
}