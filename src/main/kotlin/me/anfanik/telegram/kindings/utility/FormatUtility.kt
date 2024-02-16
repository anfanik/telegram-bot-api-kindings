package me.anfanik.telegram.kindings.utility

import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.model.request.ParseMode.*
import me.anfanik.telegram.kindings.utility.format.HtmlMarkdownFormatter
import me.anfanik.telegram.kindings.utility.format.MarkdownFormatter
import me.anfanik.telegram.kindings.utility.format.MarkdownV1MarkdownFormatter

var DEFAULT_MARKDOWN_MODE = HTML

fun String.bold(parseMode: ParseMode = DEFAULT_MARKDOWN_MODE) =
    getMarkdownFormatter(parseMode).bold(this)

fun String.italic(parseMode: ParseMode = DEFAULT_MARKDOWN_MODE) =
    getMarkdownFormatter(parseMode).italic(this)

fun String.underline(parseMode: ParseMode = DEFAULT_MARKDOWN_MODE) =
    getMarkdownFormatter(parseMode).underline(this)

fun String.strikethrough(parseMode: ParseMode = DEFAULT_MARKDOWN_MODE) =
    getMarkdownFormatter(parseMode).strikethrough(this)

fun String.spoiler(parseMode: ParseMode = DEFAULT_MARKDOWN_MODE) =
    getMarkdownFormatter(parseMode).spoiler(this)

fun String.url(url: String, parseMode: ParseMode = DEFAULT_MARKDOWN_MODE) =
    getMarkdownFormatter(parseMode).url(this, url)

fun String.emoji(emojiId: Long, parseMode: ParseMode = DEFAULT_MARKDOWN_MODE) =
    getMarkdownFormatter(parseMode).emoji(this, emojiId)

fun String.code(language: String, parseMode: ParseMode = DEFAULT_MARKDOWN_MODE) =
    getMarkdownFormatter(parseMode).code(this, language)

private fun getMarkdownFormatter(parseMode: ParseMode): MarkdownFormatter =
    when (parseMode) {
        HTML -> HtmlMarkdownFormatter
        Markdown -> MarkdownV1MarkdownFormatter
        MarkdownV2 -> TODO()
    }