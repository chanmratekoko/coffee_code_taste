package com.cmkk.concurrency.nonblocking.counter

import java.util.concurrent.atomic.AtomicInteger

/**
 * Nonblocking algorithms
 */
class CounterKotlin {

    var value = AtomicInteger()

    fun get() = value.get()

    fun increment() : Int = value.incrementAndGet()

    fun incrementLongVersion(): Int {

        var oldValue = value.get()

        while (!value.compareAndSet(oldValue, oldValue + 1)) {
            oldValue = value.get()
        }

        return oldValue + 1
    }
}