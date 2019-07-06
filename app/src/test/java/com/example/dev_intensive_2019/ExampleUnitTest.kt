package com.example.dev_intensive_2019

import com.example.dev_intensive_2019.extensions.TimesUnits
import com.example.dev_intensive_2019.extensions.add
import com.example.dev_intensive_2019.extensions.format
import com.example.dev_intensive_2019.extensions.humanizeDiff
import com.example.dev_intensive_2019.models.User
import com.example.dev_intensive_2019.utils.Utils
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun test_instance() {
        val user = User("2", "Donnw", "Joe")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("Joel Embiid")
        user?.printMe()
        val user2 = User.makeUser("  ")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("Jon Vik")
        user?.printMe()
        var user3 = user?.copy(lastVisit = Date().add(-10, TimesUnits.MINUTE))

        println(
            """
            ${user3?.lastVisit?.format()}
        """.trimIndent()
        )
    }

    @Test
    fun test_parce_name() {
        val user = User.makeUser("Jon Vik")
        Utils.parseFullName(null)
        Utils.parseFullName("Forg Nmr")
        Utils.parseFullName(" ")
        Utils.parseFullName("Hokf")
    }

    @Test
    fun test_first_character() {
        Utils.toInitials(null, null)
        Utils.toInitials("Forg", "Uiuk")
        Utils.toInitials(" ", " ")
        Utils.toInitials("Hokf", "Juyeof")

    }

    @Test
    fun test_transliterate() {
        Utils.transliteration("Ялу туги")
        Utils.transliteration("Тобби")
        Utils.transliteration("Фредди Шлор")
    }

    @Test
    fun test_humanizeDiff() {
            println(Date().humanizeDiff(Date().add(34, TimesUnits.SECOND)))
            println(Date().humanizeDiff(Date().add(-20, TimesUnits.DAY)))
            println(Date().humanizeDiff(Date().add(-60, TimesUnits.SECOND)))
            assertEquals("через несколько секунд", Date().humanizeDiff(Date().add(34, TimesUnits.SECOND)))
            assertEquals("минуту назад", Date().humanizeDiff(Date().add(-60, TimesUnits.SECOND))) //FIXME
            assertEquals("5 минут назад", Date().humanizeDiff(Date().add(-5, TimesUnits.MINUTE)))
            assertEquals("20 дней назад", Date().humanizeDiff(Date().add(-20, TimesUnits.DAY)))
            assertEquals("90 дней назад", Date().humanizeDiff(Date().add(-3, TimesUnits.MONTH)))
            assertEquals("более года назад", Date().humanizeDiff(Date().add(-6, TimesUnits.YEAR)))
            assertEquals("через несколько секунд", Date().humanizeDiff(Date().add(13, TimesUnits.SECOND)))
            assertEquals("через минуту", Date().humanizeDiff(Date().add(63, TimesUnits.SECOND)))
            assertEquals("через минуту", Date().humanizeDiff(Date().add(1, TimesUnits.MINUTE)))
            assertEquals("через 29 дней", Date().humanizeDiff(Date().add(29, TimesUnits.DAY)))
            assertEquals("более чем через год", Date().humanizeDiff(Date().add(300, TimesUnits.MONTH)))
            assertEquals("более чем через год", Date().humanizeDiff(Date().add(2, TimesUnits.YEAR)))
            assertEquals("только что", Date().humanizeDiff(Date().add(0, TimesUnits.YEAR)))
            assertEquals("через несколько секунд", Date().humanizeDiff(Date().add(-2, TimesUnits.SECOND)))
            assertEquals("через минуту", Date().humanizeDiff(Date().add(1, TimesUnits.MINUTE)))
            assertEquals("5 дней назад", Date().humanizeDiff(Date().add(-5, TimesUnits.DAY)))
            assertEquals("более чем через год", Date().humanizeDiff(Date().add(400, TimesUnits.DAY)))
            assertEquals("более года назад", Date().humanizeDiff(Date().add(-400, TimesUnits.DAY)))
            assertEquals("только что", Date().humanizeDiff(Date()))

    }
}
