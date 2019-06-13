package com.cmkk.concurrency.threads;

import java.util.ArrayList;
import java.util.List;

public class MyRunnableTest {

    public static void main(String[] args) {

        // We will store the threads so that we can check if they are done
        List<Thread> threadList = new ArrayList<>();


        // We will create 500 threads
        for (int i = 0; i < 500; i++) {
            Runnable task = new MyRunnable(10000000L + i);
            Thread worker = new Thread(task);
            // We can set the name of the thread
            worker.setName(String.valueOf(i));
            // Start the thread, never call method run() direct
            worker.start();
            // Remember the thread for later usage
            threadList.add(worker);
        }
        int running = 0;
        do {

            running = 0;

            for (Thread thread : threadList) {
                if (thread.isAlive()) {
                    running += 1;
                }
                System.out.println("We have " + running + " running threads. ");
            }
        } while (running > 0);
    }
}
