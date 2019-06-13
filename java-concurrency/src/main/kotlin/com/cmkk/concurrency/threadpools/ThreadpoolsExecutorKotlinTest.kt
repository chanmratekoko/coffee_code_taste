package com.cmkk.concurrency.threadpools

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ThreadpoolsExecutorKotlinTest {
    companion object {
        @JvmStatic
        val NTHREDS = 10
    }
}

fun main() {
    val executorService : ExecutorService = Executors.newFixedThreadPool(ThreadpoolsExecutorKotlinTest.NTHREDS)

    for(i in 0..500){
        val runnable : Runnable = MyRunnableKotlin(10000000L + i)
        executorService.execute(runnable)
    }

    // This will make the executor accept no new threads
    // and finish all existing threads in the queue

    executorService.shutdown()
    // Wait until all threads are finish
    executorService.awaitTermination(10 , TimeUnit.SECONDS)

    System.out.println("Finished all threads")
}