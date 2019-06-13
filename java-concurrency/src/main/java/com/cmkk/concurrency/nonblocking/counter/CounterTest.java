package com.cmkk.concurrency.nonblocking.counter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CounterTest {

    private static final int NTHREDS = 10;

    public static void main(String[] args) {


        final Counter counter = new Counter();

        List<Future<Integer>> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(NTHREDS);

        for (int i = 0; i < 500; i++) {

            Callable<Integer> worker = () -> {
                int number = counter.increment();
                System.out.println(number);
                return number;
            };

            Future<Integer> submit = executorService.submit(worker);

            list.add(submit);
        }

        // This will make the executor accept no new threads
        // and finish all existing threads in the queue

        executorService.shutdown();

        // Wait until all threads are finish

        while (!executorService.isTerminated()) ;

        Set<Integer> set = new HashSet<>();


        for (Future<Integer> future : list) {
            try {
                set.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        if (list.size() != set.size()) {
            throw new RuntimeException("Double-entries!!!");
        }

        String output = set.stream().map(String::valueOf).collect(Collectors.joining(","));

        System.out.println(output);
    }
}
