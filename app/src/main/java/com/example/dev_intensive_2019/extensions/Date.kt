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
    var currentDate:Int  = abs((currentTime - date.time).toInt())
    println("$currentDate + current Time = $currentTime + DateaNEW = ${date.time}")
    var MINUTES = currentDate/SECOND / 60
    var HOURS = MINUTES / 60
    var DAYS = HOURS / 24
    var MONTHS = DAYS / 30
    var YEARS = DAYS / 365
    if (currentTime > date.time) {
        println(currentDate)
        return when {
            currentDate < MINUTE -> "несколько секунд назад"
            currentDate >= MINUTE && (currentDate % 10) == 1 -> "минуту назад"
            currentDate >= MINUTE && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "$MINUTE минут назад"
            currentDate >= MINUTE && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "$MINUTE минуты назад"
            currentDate >= HOUR && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "$HOURS часа назад"
            currentDate >= HOUR && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "$HOURS часов назад"
            currentDate >= HOUR && (currentDate % 10) == 1 -> "$HOURS час назад"
            currentDate >= DAY && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "$DAYS дней назад"
            currentDate >= DAY && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "$DAYS дня назад"
            currentDate >= DAY && (currentDate % 10) == 1 -> "$DAYS день назад"
            currentDate > YEAR && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "более года назад"
            currentDate.toLong() == YEAR -> "$YEARS год назад"

            else -> " некорректный интервал"
        }
    }
    if (currentTime < date.time) {
        println(currentDate)
        return when {
            currentDate < MINUTE -> "через несколько секунд"
            currentDate >= MINUTE && (currentDate % 10) == 1 -> "через $MINUTES минуту"
            currentDate >= MINUTE && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "через $MINUTES минут"
            currentDate >= MINUTE && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "через $MINUTES минуты"
            currentDate >= HOUR && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "через $HOURS часа"
            currentDate >= HOUR && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "через $HOURS часов"
            currentDate >= HOUR && (currentDate % 10) == 1 -> "$HOURS час назад"
            currentDate >= DAY && (currentDate % 10) == 0 || (currentDate % 10) >= 5 -> "через $DAYS дней"
            currentDate >= DAY && (currentDate % 10) > 1 || (currentDate % 10) > 5 -> "через $DAYS дня"
            currentDate >= DAY && (currentDate % 10) == 1 -> "$DAYS день назад"
            currentDate > YEAR && (currentDate % 10) == 1 -> "более чем через год"
            currentDate.toLong() == YEAR -> "через $YEARS год"
            else -> " некорректный интервал"

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

