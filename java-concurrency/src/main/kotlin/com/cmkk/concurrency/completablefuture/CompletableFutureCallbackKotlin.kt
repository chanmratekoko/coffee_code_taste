package com.cmkk.concurrency.completablefuture

fun main() {

    val data = createCompletableFuture()
        .thenApply { count -> count + 10 }
        .thenApply { transformed -> "Finally created a string $transformed" }

    println(data.get())
}