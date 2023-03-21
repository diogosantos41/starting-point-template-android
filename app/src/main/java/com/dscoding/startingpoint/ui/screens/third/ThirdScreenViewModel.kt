package com.dscoding.startingpoint.ui.screens.third

import androidx.lifecycle.viewModelScope
import com.dscoding.startingpoint.domain.model.Contact
import com.dscoding.startingpoint.domain.repository.DbRepository
import com.dscoding.startingpoint.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ThirdScreenState(
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortType: ContactSortType = ContactSortType.FIRST_NAME
)

@HiltViewModel
class ThirdScreenViewModel @Inject constructor(private val dbRepository: DbRepository) :
    BaseViewModel<ThirdScreenState>() {

    override fun initialState(): ThirdScreenState {
        return ThirdScreenState()
    }

    private val _sortType = MutableStateFlow(ContactSortType.FIRST_NAME)
    private val _contacts = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                ContactSortType.FIRST_NAME -> dbRepository.getContactsOrderedByFirstName()
                ContactSortType.LAST_NAME -> dbRepository.getContactsOrderedByLastName()
                ContactSortType.PHONE_NUMBER -> dbRepository.getContactsOrderedByPhoneNumber()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(initialState())
    val state = combine(_state, _sortType, _contacts) { state, sortType, contacts ->
        state.copy(
            contacts = contacts,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), initialState())

    fun onEvent(event: ThirdScreenEvent) {
        when (event) {
            is ThirdScreenEvent.DeleteContact -> {
                viewModelScope.launch {
                    dbRepository.deleteContact(event.contact)
                }
            }
            ThirdScreenEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingContact = false
                    )
                }
            }
            ThirdScreenEvent.SaveContact -> {
                val firstName = state.value.firstName
                val lastName = state.value.lastName
                val phoneNumber = state.value.phoneNumber

                if (firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank()) {
                    return
                }

                val contact = Contact(
                    firstName = firstName,
                    lastName = lastName,
                    phoneNumber = phoneNumber
                )
                viewModelScope.launch {
                    dbRepository.upsertContact(contact)
                }
                _state.update {
                    it.copy(
                        isAddingContact = false,
                        firstName = "",
                        lastName = "",
                        phoneNumber = ""
                    )
                }
            }
            is ThirdScreenEvent.SetFirstName -> {
                _state.update {
                    it.copy(
                        firstName = event.firstName
                    )
                }
            }
            is ThirdScreenEvent.SetLastName -> {
                _state.update {
                    it.copy(
                        lastName = event.lastName
                    )
                }
            }
            is ThirdScreenEvent.SetPhoneNumber -> {
                _state.update {
                    it.copy(
                        phoneNumber = event.phoneNumber
                    )
                }
            }
            ThirdScreenEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        isAddingContact = true
                    )
                }
            }
            is ThirdScreenEvent.SortContacts -> {
                _sortType.value = event.sortType
            }
        }
    }
}
