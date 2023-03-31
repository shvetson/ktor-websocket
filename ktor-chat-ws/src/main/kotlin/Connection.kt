package ru.shvets.chat

import io.ktor.websocket.*
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author  Oleg Shvets
 * @version 1.0
 * @date  31.03.2023 21:57
 */

class Connection(val session: DefaultWebSocketSession) {
    companion object {
        var lastId = AtomicInteger(0)
    }
    val name = "user${lastId.getAndIncrement()}"
}