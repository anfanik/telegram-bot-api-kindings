package me.anfanik.telegram.kindings.utility.format

interface MarkdownFormatter {

    fun bold(text: String): String

    fun italic(text: String): String

    fun underline(text: String): String

    fun strikethrough(text: String): String

    fun spoiler(text: String): String

    fun url(text: String, url: String): String

    fun emoji(fallbackEmoji: String, emojiId: Long): String

    fun code(text: String, language: String?): String

}