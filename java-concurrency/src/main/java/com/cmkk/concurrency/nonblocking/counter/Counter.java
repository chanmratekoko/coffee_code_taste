package com.cmkk.concurrency.nonblocking.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Nonblocking algorithms
 */
public class Counter {

    private final AtomicInteger value = new AtomicInteger();

    public int getValue() {
        return value.get();
    }

    public int increment() {
        return value.incrementAndGet();
    }

    public int incrementLongVersion() {

        int oldValue = value.get();

        while (!value.compareAndSet(oldValue, oldValue + 1)) {
            oldValue = value.get();
        }

        return oldValue + 1;
    }
}
