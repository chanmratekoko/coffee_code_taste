package com.cmkk.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {

        // Initialize the semaphore with 1 permit
        Semaphore semaphore = new Semaphore(1);

        // Create and start worker threads
        Thread t1 = new Thread(new Worker(semaphore));
        Thread t2 = new Thread(new Worker(semaphore));

        t1.start();
        t2.start();

        try {
            // Wait for the worker threads to finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
