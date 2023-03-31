package ru.shvets.chat

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.shvets.chat.plugins.configureRouting
import ru.shvets.chat.plugins.configureSerialization
import ru.shvets.chat.plugins.configureSockets

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureSerialization()
    configureRouting()
}
