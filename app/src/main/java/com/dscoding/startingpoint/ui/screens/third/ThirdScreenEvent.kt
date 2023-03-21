package com.dscoding.startingpoint.ui.screens.third

import com.dscoding.startingpoint.domain.model.Contact

sealed interface ThirdScreenEvent {
    object SaveContact: ThirdScreenEvent
    data class SetFirstName(val firstName: String): ThirdScreenEvent
    data class SetLastName(val lastName: String): ThirdScreenEvent
    data class SetPhoneNumber(val phoneNumber: String): ThirdScreenEvent
    object ShowDialog: ThirdScreenEvent
    object HideDialog: ThirdScreenEvent
    data class SortContacts(val sortType: ContactSortType): ThirdScreenEvent
    data class DeleteContact(val contact: Contact): ThirdScreenEvent
}