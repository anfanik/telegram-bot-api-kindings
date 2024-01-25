package me.anfanik.telegram.kindings.utility.extension

import com.pengrad.telegrambot.model.User

val User.displayName: String
    get() = listOfNotNull(firstName(), lastName()).joinToString(" ")

val User.link: String
    get() = username()?.let { "https://t.me/$it" }
        ?: "tg://user?id=${id()}"