package com.itschool.jpa.concurancy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExamples {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String... args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> System.out.println(atomicInteger.incrementAndGet() + " TreadId: " + Thread.currentThread().getId()));
        }

        executorService.shutdown();
    }
}
