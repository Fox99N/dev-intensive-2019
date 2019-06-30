package com.example.dev_intensive_2019.models

import java.util.*

    data class User(
        val id: String,
        var firstName: String?,
        var lastName: String?,
        var avatar: String?,
        var raiting: Int = 0,
        var respect: Int = 0,
        var lastVisit: Date? = Date(),
        var isOnline: Boolean = false


) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
         id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null

    )
    constructor(id: String, firstName: String?, lastName: String?, lastVisit: Date?) : this(
            id = id,
            firstName = firstName,
            lastName = lastName,
            lastVisit = lastVisit,
            avatar = null

        )

    companion object Factory {
        private var lastid: Int = -1
        fun makeUser(fullName: String): User? {
            if(fullName != null && !fullName.isBlank()){
                lastid++
                val parts: List<String>? = fullName.split(" ")

                val firstName = parts?.getOrNull(0)
                val lastName = parts?.getOrNull(1)

                return User(id= "$lastid", firstName = firstName, lastName = lastName )
            } else {
                print("User cannot be null")
                return null
            }
        }
    }

     fun printMe() = println("""
         id: $id
         firstNmae: $firstName
         lastName: $lastName
         avatar: $avatar
         raiting: $raiting
         respect: $respect
         lastVisit: $lastVisit
         isOnLine: $isOnline

     """.trimIndent()

     )
}
