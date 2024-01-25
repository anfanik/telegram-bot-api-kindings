package me.anfanik.telegram.kindings.utility.extension

import com.pengrad.telegrambot.model.Chat

val Chat.displayName: String
    get() = title()
        ?: listOfNotNull(firstName(), lastName()).joinToString(" ")

val Chat.link: String
    get() = username()?.let { "https://t.me/$it" }
        ?: inviteLink()
        ?: "tg://${type().name.lowercase()}?id=${id()}"