package com.cmkk.concurrency.semaphore

import java.util.concurrent.Semaphore

class WorkerKotlin(private val semaphore : Semaphore) : Runnable {

    override fun run() {
        val threadName = Thread.currentThread().name

        try {

            // Acquire a permit
            semaphore.acquire()

            // Access the shared resource or critical section
            println("Worker acquired a resource. $threadName")

            // Simulate some work
            Thread.sleep(2000)

            println("Worker released a resource. $threadName")

            // Release the permit
            semaphore.release()
        } catch (ex : InterruptedException) {
            ex.printStackTrace()
        }
    }

}