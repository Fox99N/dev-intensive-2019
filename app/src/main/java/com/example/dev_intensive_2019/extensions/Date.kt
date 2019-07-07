package com.example.dev_intensive_2019.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs
import kotlin.math.roundToLong


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

fun Date.humanizeDiff(): String? {
    println("date =  and dateTime - ${Date().time}")
    val currentTime: Long = System.currentTimeMillis()
    var delta: Long = abs((currentTime - Date().time))
    println("$delta + current Time = $currentTime + DateaNEW = ${Date()}  DATE TIME = ${Date().time}")
    var MINUTES: Long = delta / 1000 / 60
    var HOURS = MINUTES / 60
    var DAYS = ((HOURS / 24).toDouble()).roundToLong()
    var MONTHS = ((DAYS / 30).toDouble()).roundToLong()
    var YEARS = DAYS / 365
    if (currentTime > Date().time) {
        println(delta)
        return when {
            delta < MINUTE -> "несколько секунд назад"
            MINUTES == 1L -> "минуту назад"
            (delta in (MINUTE + 1) until HOUR) && ((MINUTES % 10) == 0L || (MINUTES % 10) >= 5) -> "$MINUTES минут назад"
            (delta in (MINUTE + 1) until HOUR) && ((MINUTES % 10) > 1 || (MINUTES % 10) > 5) -> "$MINUTES минуты назад"
            (delta in (HOUR + 1).. (DAY- HOUR)) && ((HOURS % 10) > 1 || (HOURS % 10) > 5) -> "$HOURS часа назад"
            (delta in (HOUR + 1).. (DAY- HOUR))  && (HOURS % 10) == 0L || (HOURS % 10) >= 5 -> "$HOURS часов назад"
            HOURS == 1L -> "час назад"
            delta in (DAY + 1) until YEAR && (DAYS % 10) == 0L || (DAYS % 10) >= 5 -> "$DAYS дней назад"
            delta in (DAY + 1) until YEAR && (DAYS % 10) > 1 || (DAYS % 10) > 5 -> "$DAYS дня назад"
            DAYS == 1L -> "день назад"
            delta > YEAR -> "более года назад"
            YEARS == 1L -> "год назад"
            else -> " некорректный интервал 1"
        }
    }
    if (currentTime < Date().time) {
        println(delta)
        return when {
            delta < MINUTE -> "через несколько секунд"
            MINUTES == 1L -> "через минуту"
            (delta in (MINUTE + 1) until HOUR) && (delta % 10) == 0L || (delta % 10) >= 5 -> "через $MINUTES минут"
            (delta in (MINUTE + 1) until HOUR) && (delta % 10) > 1 || (delta % 10) > 5 -> "через $MINUTES минуты"
            (delta in (HOUR + 1).. (DAY- HOUR))  && (HOURS % 10) > 1 || (HOURS % 10) > 5 -> "через $HOURS часа"
            (delta in (HOUR + 1).. (DAY- HOUR))  && (HOURS % 10) == 0L || (HOURS % 10) >= 5 -> "через $HOURS часов"
            HOURS == 1L -> "час назад"
            delta in (DAY + 1) until YEAR && (DAYS % 10) == 0L || (DAYS % 10) >= 5 -> "через $DAYS дней"
            delta in (DAY + 1) until YEAR && (DAYS % 10) > 1 || (DAYS % 10) > 5 -> "через $DAYS дня"
            DAYS == 1L -> "через день"
            delta > YEAR && (delta % 10) == 0L || (delta % 10) >= 5 -> "более чем через год"
            delta == YEAR -> "через $YEARS год"
            else -> " некорректный интервал 2"

        }
    } else if (currentTime == Date().time) {
        return "только что"
    }
    return null
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        TimeUnits.MONTH -> value * MONTH
        TimeUnits.YEAR -> value * YEAR
    }
    this.time = time
    return this
}

//fun Date.humanizeDiff(date: Date): String? {
//    println("date = $date and dateTime - ${date.time}")
//    val currentTime: Long = System.currentTimeMillis()
//    var delta: Long = abs((currentTime - date.time))
//    println("$delta + current Time = $currentTime + DateaNEW = ${date}  DATE TIME = ${date.time}")
//    var MINUTES: Long = delta / 1000 / 60
//    var HOURS = MINUTES / 60
//    var DAYS = ((HOURS / 24).toDouble()).roundToLong()
//    var MONTHS = ((DAYS / 30).toDouble()).roundToLong()
//    var YEARS = DAYS / 365
//    if (currentTime > date.time) {
//        println(delta)
//        return when {
//            delta < MINUTE -> "несколько секунд назад"
//            MINUTES == 1L -> "минуту назад"
//            (delta in (MINUTE + 1) until HOUR) && ((MINUTES % 10) == 0L || (MINUTES % 10) >= 5) -> "$MINUTES минут назад"
//            (delta in (MINUTE + 1) until HOUR) && ((MINUTES % 10) > 1 || (MINUTES % 10) > 5) -> "$MINUTES минуты назад"
//            (delta in (HOUR + 1).. (DAY- HOUR)) && ((HOURS % 10) > 1 || (HOURS % 10) > 5) -> "$HOURS часа назад"
//            (delta in (HOUR + 1).. (DAY- HOUR))  && (HOURS % 10) == 0L || (HOURS % 10) >= 5 -> "$HOURS часов назад"
//            HOURS == 1L -> "час назад"
//            delta in (DAY + 1) until YEAR && (DAYS % 10) == 0L || (DAYS % 10) >= 5 -> "$DAYS дней назад"
//            delta in (DAY + 1) until YEAR && (DAYS % 10) > 1 || (DAYS % 10) > 5 -> "$DAYS дня назад"
//            DAYS == 1L -> "день назад"
//            delta > YEAR -> "более года назад"
//            YEARS == 1L -> "год назад"
//            else -> " некорректный интервал 1"
//        }
//    }
//    if (currentTime < date.time) {
//        println(delta)
//        return when {
//            delta < MINUTE -> "через несколько секунд"
//            MINUTES == 1L -> "через минуту"
//            (delta in (MINUTE + 1) until HOUR) && (delta % 10) == 0L || (delta % 10) >= 5 -> "через $MINUTES минут"
//            (delta in (MINUTE + 1) until HOUR) && (delta % 10) > 1 || (delta % 10) > 5 -> "через $MINUTES минуты"
//            (delta in (HOUR + 1).. (DAY- HOUR))  && (HOURS % 10) > 1 || (HOURS % 10) > 5 -> "через $HOURS часа"
//            (delta in (HOUR + 1).. (DAY- HOUR))  && (HOURS % 10) == 0L || (HOURS % 10) >= 5 -> "через $HOURS часов"
//            HOURS == 1L -> "час назад"
//            delta in (DAY + 1) until YEAR && (DAYS % 10) == 0L || (DAYS % 10) >= 5 -> "через $DAYS дней"
//            delta in (DAY + 1) until YEAR && (DAYS % 10) > 1 || (DAYS % 10) > 5 -> "через $DAYS дня"
//            DAYS == 1L -> "через день"
//            delta > YEAR && (delta % 10) == 0L || (delta % 10) >= 5 -> "более чем через год"
//            delta == YEAR -> "через $YEARS год"
//            else -> " некорректный интервал 2"
//
//        }
//    } else if (currentTime == date.time) {
//        return "только что"
//    }
//    return null
//}