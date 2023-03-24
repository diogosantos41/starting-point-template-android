package com.dscoding.startingpoint.ui.screens.third

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddContactDialog(
    state: ThirdScreenState,
    onEvent: (ThirdScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.background,
        onDismissRequest = {
            onEvent(ThirdScreenEvent.HideDialog)
        },
        title = {
            Text(
                text = "Add contact",
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.firstName,
                    onValueChange = {
                        onEvent(ThirdScreenEvent.SetFirstName(it))
                    },
                    placeholder = {
                        Text(
                            text = "First name",
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
                TextField(
                    value = state.lastName,
                    onValueChange = {
                        onEvent(ThirdScreenEvent.SetLastName(it))
                    },
                    placeholder = {
                        Text(
                            text = "Last name",
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
                TextField(
                    value = state.phoneNumber,
                    onValueChange = {
                        onEvent(ThirdScreenEvent.SetPhoneNumber(it))
                    },
                    placeholder = {
                        Text(
                            text = "Phone number",
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        },
        buttons = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colorScheme.primary),
                    onClick = {
                    onEvent(ThirdScreenEvent.SaveContact)
                }) {
                    Text(text = "Save")
                }
            }
        }
    )
}