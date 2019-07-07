package com.example.dev_intensive_2019

import com.example.dev_intensive_2019.extensions.TimeUnits
import com.example.dev_intensive_2019.extensions.add
import com.example.dev_intensive_2019.extensions.format
import com.example.dev_intensive_2019.extensions.humanizeDiff
import com.example.dev_intensive_2019.models.User
import com.example.dev_intensive_2019.utils.Utils
import org.junit.Assert.assertEquals
import org.junit.Test
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
        var user3 = user?.copy(lastVisit = Date().add(-10, TimeUnits.MINUTE))

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
        assertEquals("2 часа назад", Date().add(-2, TimeUnits.HOUR).humanizeDiff())  //2 часа назад
        assertEquals("5 дней назад", Date().add(-5, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 2 минуты", Date().add(2, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через 7 дней", Date().add(7, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 7 дней", Date().add(7, TimeUnits.DAY).humanizeDiff())
        assertEquals("более года назад", Date().add(-400, TimeUnits.DAY).humanizeDiff())
        assertEquals("более чем через год", Date().add(-400, TimeUnits.DAY).humanizeDiff())

    }

    @Test
    fun builder_pattern(){
        val user4 = User.Builder("id_uder", "Skr", "YURR", "avatarrr", 2, 3, Date().add(3, TimeUnits.DAY), true)
            .build()
        println(user4.toString())
    }
}

