package com.dscoding.startingpoint.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dscoding.startingpoint.domain.model.Contact

@Database(entities = [Contact::class], version = 1)

abstract class ContactDatabase : RoomDatabase() {
    abstract val contactDao: ContactDao
}