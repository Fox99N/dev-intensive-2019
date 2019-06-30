package com.example.dev_intensive_2019

import com.example.dev_intensive_2019.extensions.TimesUnits
import com.example.dev_intensive_2019.extensions.add
import com.example.dev_intensive_2019.extensions.format
import com.example.dev_intensive_2019.models.User
import com.example.dev_intensive_2019.utils.Utils
import org.junit.Test

import org.junit.Assert.*
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
    fun test_instance(){
        val user = User("2", "Donnw", "Joe")
    }

    @Test
    fun test_factory(){
        val user = User.makeUser("Joel Embiid")
        user?.printMe()
        val user2 = User.makeUser("  ")
    }

    @Test
    fun test_copy(){
        val user = User.makeUser("Jon Vik")
        user?.printMe()
        var user3 = user?.copy(lastVisit = Date().add(2, TimesUnits.DAY))

        println("""
            ${user3?.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_parce_name(){
        val user = User.makeUser("Jon Vik")
        Utils.parseFullName(null)
        Utils.parseFullName("Forg Nmr")
        Utils.parseFullName(" ")
        Utils.parseFullName("Hokf")
    }

    @Test
    fun test_first_character(){
        Utils.toInitials(null, null)
        Utils.toInitials("Forg", "Uiuk")
        Utils.toInitials(" ", " ")
        Utils.toInitials("Hokf", "Juyeof")

    }
}
