package com.cmkk.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallback {

    public static void main(String[] args) {

        long started = System.currentTimeMillis();

        CompletableFuture<String> data = createCompletableFuture()
                .thenApply((Integer count) -> count * 10).thenApply(transformValue -> "Finally creates a string: " + transformValue);

        System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds");

        try {
            System.out.println(data.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // simulate long running task
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });
    }
}
