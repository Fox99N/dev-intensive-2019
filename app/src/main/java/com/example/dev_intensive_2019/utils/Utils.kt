package com.example.dev_intensive_2019.utils

import android.os.Build
import android.support.annotation.RequiresApi
import java.io.File
import java.lang.StringBuilder
import java.nio.file.Files


object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        print(firstName to lastName)
        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?): Pair<Char?, Char?> {

        val firstLatter: Char? = firstName?.getOrNull(0)
        val lastNameLatter: Char? = lastName?.getOrNull(0)
        print(firstLatter to lastNameLatter)
        return firstLatter to lastNameLatter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun transliteration(fullName: String?): String {
        var arrayForRead = readFileLine()
        var translatedString = StringBuilder()
        val charList: CharArray? = fullName?.toCharArray()
        if (charList != null) {
            for(char in charList){
                translatedString.append(arrayForRead.get(char.toString()))
            }
        }
        println(translatedString.toString())
        return translatedString.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun readFileLine(): Map<String, String> {
        var mapTruncated = Files.readAllLines(File("latin_translate").toPath()).map {
            it.replace("\"", " ")
                .replace(" ", "")
                .replace(",", "")
        }.filter { it.isNotEmpty() }.associate {  val (left, right) = it.split(":")
            left to right
        }
           return  mapTruncated
    }
}
