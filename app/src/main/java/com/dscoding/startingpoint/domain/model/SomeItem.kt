package com.dscoding.startingpoint.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dscoding.startingpoint.domain.model.SomeItem.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class SomeItem(
    val title: String,
    @PrimaryKey val id: Int? = null
) {

    companion object {
        const val TABLE_NAME = "item_table"
    }
}
