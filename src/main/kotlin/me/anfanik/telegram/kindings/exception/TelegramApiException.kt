package me.anfanik.telegram.kindings.exception

import com.pengrad.telegrambot.response.BaseResponse

class TelegramApiException(response: BaseResponse) :
    RuntimeException("Unhandled error while calling Telegram API: ${response.description()}")