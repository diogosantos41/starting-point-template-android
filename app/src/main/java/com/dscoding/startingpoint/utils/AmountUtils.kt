package com.dscoding.startingpoint.utils

import java.math.RoundingMode
import java.text.DecimalFormat

fun formatTwoDecimals(number: Double): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    return df.format(number)
}

fun formatToDisplayCurrency(number: Double, currency: String): String {
    return "${formatTwoDecimals(number)}${currency}"
}