package com.cmkk.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimpleSnippetTest {

    public static void main(String[] args) {

        long started = System.currentTimeMillis();

        CompletableFuture<Integer> completableFuture = createCompletableFuture();

        // continue to do other work
        System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds" );

        try {
            int count = completableFuture.get();

            System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds" );
            System.out.println("Result " + count);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                // simulate long running task
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });
        return future;
    }
}
