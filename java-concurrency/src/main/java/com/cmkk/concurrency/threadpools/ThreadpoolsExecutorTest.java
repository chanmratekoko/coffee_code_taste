package com.cmkk.concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadpoolsExecutorTest {

    private static final int NTHREDS = 10;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NTHREDS);

        for (int i = 0; i < 500; i++) {
            Runnable worker = new MyRunnable(10000000L + i);
            executorService.execute(worker);
        }

        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executorService.shutdown();

        // Wait until all threads are finish
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Finished all threads");
    }
}
