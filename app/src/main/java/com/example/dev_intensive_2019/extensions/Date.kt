package com.example.dev_intensive_2019.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs


const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
const val MONTH = 30 * DAY
const val YEAR = DAY * 365


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.humanizeDiff(date: Date): String? {
    println("date = $date and dateTime - ${date.time}")
    val currentTime: Long = System.currentTimeMillis()
    var currentDate: Int = abs((currentTime - date.time).toInt())
    println("$currentDate + current Time = $currentTime + DateaNEW = ${date}  DATE TIME = ${date.time}")
    var MINUTES: Int = currentDate / SECOND.toInt() / 60
    var HOURS = MINUTES / 60
    var DAYS = HOURS / 24
    var MONTHS = DAYS / 30
    var YEARS = DAYS / 365
    if (currentTime > date.time) {
        println(currentDate)
        return when {
            currentDate < MINUTE -> "несколько секунд назад"
            MINUTES == 1 -> "минуту назад"
            (currentDate in (MINUTE + 1)..(HOUR - 1)) && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "$MINUTES минут назад"
            (currentDate in (MINUTE + 1)..(HOUR - 1)) && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "$MINUTES минуты назад"
            (currentDate in (HOUR + 1)..(DAY - 1)) && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "$HOURS часа назад"
            (currentDate in (HOUR + 1)..(DAY - 1)) && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "$HOURS часов назад"
            HOURS == 1 -> "час назад"
            currentDate in (DAY + 1)..(YEAR - 1) && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "$DAYS дней назад"
            currentDate in (DAY + 1)..(YEAR - 1) && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "$DAYS дня назад"
            DAYS == 1 -> "день назад"
            currentDate > YEAR && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "более года назад"
            YEARS == 1 -> "год назад"
            else -> " некорректный интервал 1"
        }
    }
    if (currentTime < date.time) {
        println(currentDate)
        return when {
            currentDate < MINUTE -> "через несколько секунд"
            MINUTES == 1 -> "через минуту"
            (currentDate in (MINUTE + 1)..(HOUR - 1)) && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "через $MINUTES минут"
            (currentDate in (MINUTE + 1)..(HOUR - 1)) && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "через $MINUTES минуты"
            (currentDate in (HOUR + 1)..(DAY - 1)) && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "через $HOURS часа"
            (currentDate in (HOUR + 1)..(DAY - 1)) && (currentDate % 10) == 0 || (currentDate % 10) >= 5-> "через $HOURS часов"
            HOURS == 1 -> "через час"
            (currentDate in (HOUR + 1)..(DAY - 1)) && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "через $DAYS дней"
            (currentDate in (HOUR + 1)..(DAY - 1)) && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "через $DAYS дня"
            DAYS == 1 -> "через день"
            currentDate > YEAR && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "более чем через год"
            currentDate.toLong() == YEAR -> "через $YEARS год"

            else -> " некорректный интервал 2"

        }
    } else if (currentTime == date.time) {
        return "только что"
    }
    return null
}

fun Date.add(value: Int, units: TimesUnits = TimesUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimesUnits.SECOND -> value * SECOND
        TimesUnits.MINUTE -> value * MINUTE
        TimesUnits.HOUR -> value * HOUR
        TimesUnits.DAY -> value * DAY
        TimesUnits.MONTH -> value * MONTH
        TimesUnits.YEAR -> value * YEAR
    }
    this.time = time
    return this
}

