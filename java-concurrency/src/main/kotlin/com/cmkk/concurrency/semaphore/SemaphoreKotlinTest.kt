package com.cmkk.concurrency.semaphore

import java.util.concurrent.Semaphore

fun main() {
    // Initialize the semaphore with 1 permit
    val semaphore = Semaphore(1)

    // Create and start worker threads
    val thread1 = Thread(WorkerKotlin(semaphore))
    val thread2 = Thread(WorkerKotlin(semaphore))

    thread1.start()
    thread2.start()

    try {
        // Wait for the worker threads to finish
        thread1.join()
        thread1.join()
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}