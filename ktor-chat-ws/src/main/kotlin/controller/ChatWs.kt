package ru.shvets.chat.controller

import io.ktor.websocket.*
import ru.shvets.chat.Connection
import java.util.*
import kotlin.collections.LinkedHashSet

val connections: MutableSet<Connection> = Collections.synchronizedSet<Connection>(LinkedHashSet())

suspend fun DefaultWebSocketSession.wsChat() {
    val c = Connection(this)
    connections += c

    c.session.send("Welcome to the chat. ${connections.size} users are online")

    for (frame in incoming) {
        frame as? Frame.Text ?: continue
        val text = frame.readText()

        val message = "${c.name} $text"
        connections.forEach { it.session.send(message) }
    }
}