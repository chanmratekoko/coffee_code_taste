package com.cmkk.concurrency.completablefuture

import java.util.concurrent.CompletableFuture

fun main() {

    val started: Long = System.currentTimeMillis()

    // configure CompletableFuture
    val completableFuture = createCompletableFuture()

    // continue to do other work
    System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds")

    val count: Int = completableFuture.get()

    System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds")

    System.out.println("Result $count")

}

fun createCompletableFuture(): CompletableFuture<Int> = CompletableFuture.supplyAsync {
    Thread.sleep(5000)
    20
}