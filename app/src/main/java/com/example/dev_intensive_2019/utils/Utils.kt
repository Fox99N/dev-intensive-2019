package com.example.dev_intensive_2019.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        print(firstName to lastName)
        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?): Pair<Char?, Char?>{

        val firstLatter : Char? = firstName?.getOrNull(0)
        val lastNameLatter : Char? = lastName?.getOrNull(0)
        print(firstLatter to lastNameLatter)
        return firstLatter to lastNameLatter
    }
}