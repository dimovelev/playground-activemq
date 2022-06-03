package com.prime157.test

import javax.jms.Connection
import javax.jms.MessageConsumer
import javax.jms.MessageProducer
import javax.jms.Session

inline fun <R> Connection.use(block: (Connection) -> R): R {
    try {
        return block(this)
    } finally {
        this.close()
    }
}

inline fun <R> Session.use(block: (Session) -> R): R {
    try {
        return block(this)
    } finally {
        this.close()
    }
}

inline fun <R> MessageProducer.use(block: (MessageProducer) -> R): R {
    try {
        return block(this)
    } finally {
        this.close()
    }
}

inline fun <R> MessageConsumer.use(block: (MessageConsumer) -> R): R {
    try {
        return block(this)
    } finally {
        this.close()
    }
}
