package com.example.dev_intensive_2019.extensions

import java.text.SimpleDateFormat
import java.util.*


const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern: String = "HH:mm:ss dd.mm.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.humanizeDiff(): String {
    return ""

}

fun Date.add(value: Int, units: TimesUnits = TimesUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimesUnits.SECOND -> value * SECOND
        TimesUnits.MINUTE -> value * MINUTE
        TimesUnits.HOUR -> value * HOUR
        TimesUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}
