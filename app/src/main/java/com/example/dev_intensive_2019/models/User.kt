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
    var isOnline: Boolean = false) {

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
            if (fullName != null && !fullName.isBlank()) {
                lastid++
                val parts: List<String>? = fullName.split(" ")

                val firstName = parts?.getOrNull(0)
                val lastName = parts?.getOrNull(1)

                return User(id = "$lastid", firstName = firstName, lastName = lastName)
            } else {
                print("User cannot be null")
                return null
            }
        }
    }

    fun printMe() = println(
        """
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

    data class Builder(
        var id: String,
        var firstName: String?,
        var lastName: String?,
        var avatar: String?,
        var raiting: Int = 0,
        var respect: Int = 0,
        var lastVisit: Date? = Date(),
        var isOnline: Boolean = false

    ) {

        fun id(id: String) = apply { this.id = id }
        fun firstName(firstName: String) = apply { this.firstName = firstName }
        fun lastName(lastName: String) = apply { this.lastName = lastName }
        fun avatar(avatar: String) = apply { this.avatar = avatar }
        fun raiting(rating: Int) = apply { this.raiting = raiting }
        fun respect(respect: Int) = apply { this.respect = respect }
        fun lastVisit(lastVisit: Date) = apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline }
        fun build() = User(id, firstName, lastName, avatar, raiting, respect, lastVisit, isOnline)
    }

}
