package com.cmkk.concurrency.callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableFuturesTest {

    private static final int NTHREDS = 10;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(NTHREDS);
        List<Future<Long>> list = new ArrayList<>();

        for(int i = 0 ; i < 2000 ; i++) {
            Callable<Long> worker =  new MyCallableKotlin();
            Future<Long> future = executorService.submit(worker);
            list.add(future);
        }

        long sum = 0;

        System.out.println(list.size());

        // now retrieve the result

        for(Future<Long> future : list) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sum);
        executorService.shutdown();
    }
}
