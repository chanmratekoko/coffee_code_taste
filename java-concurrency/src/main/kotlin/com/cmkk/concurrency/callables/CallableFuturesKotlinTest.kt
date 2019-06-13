package com.cmkk.concurrency.callables

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class CallableFuturesKotlinTest {

    companion object {
        @JvmStatic
        val NTHREDS = 10
    }
}

fun main() {

    val executorService: ExecutorService = Executors.newFixedThreadPool(CallableFuturesKotlinTest.NTHREDS)

    val list: ArrayList<Future<Long>> = ArrayList()

    for (i in 0 until 2000) {
        val worker: Callable<Long> = MyCallable()
        val future: Future<Long> = executorService.submit(worker)
        list.add(future)
    }

    var sum: Long = 0
    println(list.size)

    // now retrieve the result

    for (future: Future<Long> in list) {
        sum += future.get()
    }

    println(sum)
    executorService.shutdown()
}