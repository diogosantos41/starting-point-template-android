package com.dscoding.startingpoint.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dscoding.startingpoint.domain.model.Contact.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Contact(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {
    companion object {
        const val TABLE_NAME = "contact_table"
    }
}
