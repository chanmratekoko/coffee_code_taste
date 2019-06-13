package com.cmkk.concurrency.callables

import java.util.concurrent.Callable

class MyCallableKotlin : Callable<Long> {

    override fun call(): Long {
        var sum: Long = 0
        for (i in 0 until 100) sum += i
        return sum
    }
}