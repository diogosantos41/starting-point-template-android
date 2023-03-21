package com.dscoding.startingpoint.domain.repository

import com.dscoding.startingpoint.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface DbRepository {

    fun getContactsOrderedByFirstName(): Flow<List<Contact>>

    fun getContactsOrderedByLastName(): Flow<List<Contact>>

    fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>

    suspend fun upsertContact(contact: Contact)

    suspend fun deleteContact(contact: Contact)
}