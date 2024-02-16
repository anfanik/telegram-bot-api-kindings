package me.anfanik.telegram.kindings.utility.format

import me.anfanik.telegram.kindings.exception.NotSupportedException
import kotlin.reflect.KFunction

object MarkdownV1MarkdownFormatter : MarkdownFormatter {

    override fun bold(text: String) = "*$text*"

    override fun italic(text: String) = "_${text}_"

    override fun underline(text: String): String =
        throw createNotSupportedException(this::underline)

    override fun strikethrough(text: String): String =
        throw createNotSupportedException(this::strikethrough)

    override fun spoiler(text: String): String =
        throw createNotSupportedException(this::spoiler)

    override fun url(text: String, url: String) = "[$text]($url)"

    override fun emoji(fallbackEmoji: String, emojiId: Long): String =
        throw createNotSupportedException(this::emoji)

    override fun code(text: String, language: String?) = "```${language?.let { "$it\n" } ?: ""}$text```"

    private fun createNotSupportedException(function: KFunction<Any>) =
        NotSupportedException("operation ${function.name} is not supported for Markdown V1")

}