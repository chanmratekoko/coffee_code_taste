package com.cmkk.concurrency.threads

import java.util.ArrayList

fun main() {

    // We will store the threads so that we can check if they are done
    val threadList = ArrayList<Thread>()

    // We will create 500 threads
    for (i in 0..500) {
        val task: Runnable = MyRunnableKotlin(10000000L + 1)

        val worker = Thread(task)
        // We can set the name of the thread
        worker.name = i.toString()
        // Start the thread, never call method run() direct
        worker.start()

        // Remember the thread for later usage
        threadList.add(worker)
    }

    var running: Int

    do {
        running = 0

        for (thread in threadList) {
            if (thread.isAlive) {
                running += 1
            }
        }
        println("We have $running running threads. ")
    } while (running > 0)

}