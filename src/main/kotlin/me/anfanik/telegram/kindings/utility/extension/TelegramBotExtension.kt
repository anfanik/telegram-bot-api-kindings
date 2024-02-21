package me.anfanik.telegram.kindings.utility.extension

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.request.*
import com.pengrad.telegrambot.response.*
import me.anfanik.telegram.kindings.exception.TelegramApiException

@Suppress("NOTHING_TO_INLINE")
@Throws(TelegramApiException::class)
inline fun TelegramBot.getMe() : GetMeResponse
        = execute(GetMe())

@Suppress("NOTHING_TO_INLINE")
@Throws(TelegramApiException::class)
inline fun TelegramBot.getChat(chatId: Long) : GetChatResponse
        = execute(GetChat(chatId))

@Suppress("NOTHING_TO_INLINE")
@Throws(TelegramApiException::class)
inline fun TelegramBot.getChat(chatId: String) : GetChatResponse
        = execute(GetChat(chatId))


@Throws(TelegramApiException::class)
inline fun TelegramBot.sendMessage(chatId: Long, text: String, modifier: SendMessage.() -> Unit = {}) : SendResponse
        = execute(SendMessage(chatId, text), modifier)

inline fun TelegramBot.sendMessage(chatId: String, text: String, modifier: SendMessage.() -> Unit = {}) : SendResponse
        = execute(SendMessage(chatId, text), modifier)


@Throws(TelegramApiException::class)
inline fun TelegramBot.deleteMessage(chatId: Long, messageId: Int, modifier: DeleteMessage.() -> Unit = {}) : BaseResponse
        = execute(DeleteMessage(chatId, messageId), modifier)

@Throws(TelegramApiException::class)
inline fun TelegramBot.deleteMessage(chatId: String, messageId: Int, modifier: DeleteMessage.() -> Unit = {}) : BaseResponse
        = execute(DeleteMessage(chatId, messageId), modifier)


@Throws(TelegramApiException::class)
inline fun TelegramBot.sendMediaGroup(chatId: Long, media: List<InputMedia<*>>, modifier: SendMediaGroup.() -> Unit = {}) : MessagesResponse
        = execute(SendMediaGroup(chatId, *media.toTypedArray()), modifier)

@Throws(TelegramApiException::class)
inline fun TelegramBot.sendMediaGroup(chatId: String, media: List<InputMedia<*>>, modifier: SendMediaGroup.() -> Unit = {}) : MessagesResponse
        = execute(SendMediaGroup(chatId, *media.toTypedArray()), modifier)


@Suppress("NOTHING_TO_INLINE")
@Throws(TelegramApiException::class)
inline fun TelegramBot.editMessageMedia(chatId: Long, messageId: Int, media: InputMedia<*>) : BaseResponse
        = execute(EditMessageMedia(chatId, messageId, media))

@Suppress("NOTHING_TO_INLINE")
@Throws(TelegramApiException::class)
inline fun TelegramBot.editMessageMedia(chatId: String, messageId: Int, media: InputMedia<*>) : BaseResponse
        = execute(EditMessageMedia(chatId, messageId, media))


@Throws(TelegramApiException::class)
inline fun TelegramBot.editMessageCaption(chatId: Long, messageId: Int, caption: String, modifier: EditMessageCaption.() -> Unit = {}) : BaseResponse
        = execute(EditMessageCaption(chatId, messageId).apply { caption(caption) }, modifier)

@Throws(TelegramApiException::class)
inline fun TelegramBot.editMessageCaption(chatId: String, messageId: Int, caption: String, modifier: EditMessageCaption.() -> Unit = {}) : BaseResponse
        = execute(EditMessageCaption(chatId, messageId).apply { caption(caption) }, modifier)


@Throws(TelegramApiException::class)
inline fun TelegramBot.editMessageReplyMarkup(chatId: Long, messageId: Int, modifier: EditMessageReplyMarkup.() -> Unit = {}) : BaseResponse
        = execute(EditMessageReplyMarkup(chatId, messageId), modifier)

@Throws(TelegramApiException::class)
inline fun TelegramBot.editMessageReplyMarkup(chatId: String, messageId: Int, modifier: EditMessageReplyMarkup.() -> Unit = {}) : BaseResponse
        = execute(EditMessageReplyMarkup(chatId, messageId), modifier)

@Suppress("NOTHING_TO_INLINE")
@Throws(TelegramApiException::class)
inline fun TelegramBot.removeInlineKeyboard(chatId: Long, messageId: Int) : BaseResponse
        = editMessageReplyMarkup(chatId, messageId) { replyMarkup(InlineKeyboardMarkup()) }

@Suppress("NOTHING_TO_INLINE")
@Throws(TelegramApiException::class)
inline fun TelegramBot.removeInlineKeyboard(chatId: String, messageId: Int) : BaseResponse
        = editMessageReplyMarkup(chatId, messageId) { replyMarkup(InlineKeyboardMarkup()) }


@Throws(TelegramApiException::class)
inline fun TelegramBot.forwardMessage(chatId: Long, fromChatId: Long, messageId: Int, modifier: ForwardMessage.() -> Unit = {}) : SendResponse
        = execute(ForwardMessage(chatId, fromChatId, messageId), modifier)

@Throws(TelegramApiException::class)
inline fun TelegramBot.forwardMessage(chatId: String, fromChatId: Long, messageId: Int, modifier: ForwardMessage.() -> Unit = {}) : SendResponse
        = execute(ForwardMessage(chatId, fromChatId, messageId), modifier)


@Throws(TelegramApiException::class)
inline fun <T : BaseRequest<T, R>, R : BaseResponse> TelegramBot.execute(request: T, modifier: T.() -> Unit = {}): R {
    val response = execute(request.apply(modifier))

    if (response.isOk) {
        return response
    } else throw TelegramApiException(response)
}