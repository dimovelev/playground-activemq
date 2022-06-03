package com.prime157.test

import org.apache.activemq.ActiveMQConnectionFactory
import org.apache.activemq.command.ActiveMQQueue
import javax.jms.Session
import javax.jms.TextMessage

fun main() {
    val cf = ActiveMQConnectionFactory("tcp://127.0.0.1:61616")
    val queue = ActiveMQQueue("prefix.*")
    cf.createConnection().use { con ->
        con.start()
        con.createSession(false, Session.CLIENT_ACKNOWLEDGE).use { session ->
            session.createConsumer(queue).use { consumer ->
                val msg = consumer.receive()
                if (msg is TextMessage) {
                    println("Received: ${msg.text}")
                }
                msg.acknowledge()
            }
        }
    }
}
