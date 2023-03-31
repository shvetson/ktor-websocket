package ru.shvets.chat.routes

import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import ru.shvets.chat.controller.wsChat

fun Route.chatRoute() {

    webSocket("/chat") {
        wsChat()
    }
}
