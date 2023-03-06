package com.dscoding.startingpoint.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dscoding.startingpoint.common.getDeviceManufacturer
import com.dscoding.startingpoint.common.getDeviceName
import com.dscoding.startingpoint.common.getOsVersion
import com.dscoding.startingpoint.ui.screens.settings.components.SettingsField
import com.dscoding.startingpoint.ui.screens.settings.components.SettingsHeader
import com.dscoding.startingpoint.utils.extensions.launchShareAppIntent
import com.dscoding.startingpoint.utils.extensions.openGooglePlayAppPage
import com.dscoding.startingpoint.utils.extensions.openSourceCodePage

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    // val showGreetingState = viewModel.showGreetingFieldState.value
    // val twentyFourHourClockState = viewModel.twentyFourHourClockFieldState.value
    // val state = viewModel.state.value

    val headerTopMargin = 20.dp
    val horizontalPadding = 24.dp
    val betweenFieldsMargin = 15.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = horizontalPadding)
                .verticalScroll(
                    rememberScrollState()
                )
                .fillMaxWidth()
        )
        {
            Spacer(modifier = Modifier.height(headerTopMargin))
            SettingsHeader("About")
            Spacer(modifier = Modifier.height(betweenFieldsMargin))
            SettingsField(
                "GitHub Source Code",
                "Take a look behind the scenes",
                onClick = { context.openSourceCodePage() }
            )
            Spacer(modifier = Modifier.height(betweenFieldsMargin))
            SettingsField(
                "Share Source Code",
                "Share the code with like-minded people",
                onClick = { context.launchShareAppIntent() }
            )
            Spacer(modifier = Modifier.height(betweenFieldsMargin))
            SettingsField(
                "Take Note! App",
                "Check out my notes application",
                onClick = { context.openGooglePlayAppPage() }
            )

            Spacer(modifier = Modifier.height(20.dp))
            Divider(color = Gray)
            Spacer(modifier = Modifier.height(headerTopMargin))
            SettingsHeader("Device Information")
            Spacer(modifier = Modifier.height(betweenFieldsMargin))
            SettingsField(
                "Device name",
                getDeviceName()
            )
            Spacer(modifier = Modifier.height(betweenFieldsMargin))
            SettingsField(
                "Device Manufacturer",
                getDeviceManufacturer()
            )
            Spacer(modifier = Modifier.height(betweenFieldsMargin))
            SettingsField(
                "OS Version",
                getOsVersion()
            )
        }
    }
}

/*
fun getDeviceName(): String = Build.MODEL

    fun getDeviceManufacturer(): String = Build.MANUFACTURER

    fun getOsVersion(): String = Build.VERSION.RELEASE
 */

