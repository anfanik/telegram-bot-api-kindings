# Java Telegram Bot API Kindings

Kindings is `💡 kotlin bindings` for [Java Telegram Bot API](https://github.com/pengrad/java-telegram-bot-api)

Features:
* 🛠 `WIP` Kotlin-style API methods for all [available methods](https://core.telegram.org/bots/api#available-methods)
* 🛠 `TODO` Markdown methods for [String Templates](https://kotlinlang.org/docs/strings.html#string-templates)
* ❌ `TODO` [Type-safe builders](https://kotlinlang.org/docs/type-safe-builders.html) for requests

## Usage
Add `telegram-bot-api-kindings` dependency of the same version as [java-telegram-bot-api](https://github.com/pengrad/java-telegram-bot-api)

* Gradle with Kotlin DSL

    Add [repository.anfanik.me]("https://repository.anfanik.me") repository:
    ```kotlin
    maven("https://repository.anfanik.me/public")
    ```
  
    Add `telegram-bot-api-kindings` dependency:
    ```kotlin
    implementation("me.anfanik:telegram-bot-api-kindings:7.0.0")
    ```

## Examples

You can use API method-specific implemented functions like `sendMessage`: 

```kotlin
telegram.sendMessage(chatId = "anfanik", text = "Hello ${"world".bold()}!") {
    parseMode(ParseMode.HTML)
}
```

or general `execute` function for not-implemented API methods:

```kotlin
telegram.execute(SendMessage("anfanik", "Hello ${"world".bold()}!")) {
    parseMode(ParseMode.HTML)
}
```