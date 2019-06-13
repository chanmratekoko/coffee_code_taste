package com.cmkk.concurrency.nonblocking.counter

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.stream.Collectors

class CounterKotlinTest {
    companion object {
        @JvmStatic
        val NTHREDS = 10
    }
}

fun main() {
    val counter = CounterKotlin()

    val list: ArrayList<Future<Int>> = ArrayList()

    val executorService = Executors.newFixedThreadPool(CounterKotlinTest.NTHREDS)

    for (i in 0 until 500) {
        val worker: Callable<Int> = Callable {
            val number: Int = counter.increment()
            println(number)
            number
        }

        val future: Future<Int> = executorService.submit(worker)

        list.add(future)
    }

    // This will make the executor accept no new threads
    // and finish all existing threads in the queue

    executorService.shutdown()

    while (!executorService.isTerminated);

    val set: HashSet<Int> = HashSet()

    for (future in list) {
        set.add(future.get())
    }

    if (list.size != set.size) {
        throw RuntimeException("Double-entries!!!")
    }

    val output = set.stream()
            .map { it.toString() }
            .collect(Collectors.joining(","))

    println(output)

}