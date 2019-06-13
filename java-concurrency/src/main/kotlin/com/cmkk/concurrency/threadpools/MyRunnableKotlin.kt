package com.cmkk.concurrency.threadpools


/**
 * MyRunnable will count the sum of the number from 1 to the parameter
 * countUntil and then write the result to the console.
 * <p>
 * MyRunnable is the task which will be performed
 *
 */
class MyRunnableKotlin(val countUntil: Long) : Runnable {

    override fun run() {
        var sum : Long = 0
        for (i in 1..countUntil) {
            sum += i
        }
        println(sum)
    }

}