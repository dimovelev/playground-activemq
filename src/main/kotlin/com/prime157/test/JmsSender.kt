package com.prime157.test

import org.apache.activemq.ActiveMQConnectionFactory
import org.apache.activemq.command.ActiveMQQueue
import javax.jms.Session

fun main() {
    val cf = ActiveMQConnectionFactory("tcp://127.0.0.1:61616")
    val queue = ActiveMQQueue("prefix.queue1")
    cf.createConnection().use { con ->
        con.start()
        con.createSession(false, Session.CLIENT_ACKNOWLEDGE).use { session ->
            session.createProducer(queue).use { producer ->
                val msg = session.createTextMessage("Hello there")
                producer.send(msg)
            }
        }
    }
}

