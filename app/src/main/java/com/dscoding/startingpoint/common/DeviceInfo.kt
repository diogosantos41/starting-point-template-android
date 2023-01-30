package com.dscoding.startingpoint.common

import android.os.Build

class DeviceInfo {

    fun getDeviceName(): String = Build.MODEL

    fun getDeviceManufacturer(): String = Build.MANUFACTURER

    fun getOsVersion(): String = Build.VERSION.RELEASE
}