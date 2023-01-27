package com.dscoding.startingpoint.utils

import android.os.Build

fun supportDynamicColors(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
