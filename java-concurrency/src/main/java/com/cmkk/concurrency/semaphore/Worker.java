package com.cmkk.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class Worker implements Runnable {

    private final Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        var threadName = Thread.currentThread().getName();

        try {
            // Acquire a permit
            semaphore.acquire();

            // Access the shared resource or critical section
            System.out.println("Worker acquired a resource. " + threadName);

            // Simulate some work
            Thread.sleep(2000);

            System.out.println("Worker released a resource. " + threadName);

            // Release the permit
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
