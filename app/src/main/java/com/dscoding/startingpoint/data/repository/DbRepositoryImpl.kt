package com.dscoding.startingpoint.data.repository

import com.dscoding.startingpoint.data.data_source.ContactDao
import com.dscoding.startingpoint.domain.model.Contact
import com.dscoding.startingpoint.domain.repository.DbRepository
import kotlinx.coroutines.flow.Flow

class DbRepositoryImpl(
    private val dao: ContactDao
) : DbRepository {
    override fun getContactsOrderedByFirstName(): Flow<List<Contact>> {
        return dao.getContactsOrderedByFirstName()
    }

    override fun getContactsOrderedByLastName(): Flow<List<Contact>> {
        return dao.getContactsOrderedByLastName()
    }

    override fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>> {
        return dao.getContactsOrderedByPhoneNumber()
    }

    override suspend fun upsertContact(contact: Contact) {
        dao.upsertContact(contact)
    }

    override suspend fun deleteContact(contact: Contact) {
        dao.deleteContact(contact)
    }

}
