package com.itschool.jpa.otherstuff.concurancy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountUsingLock {
    public static int count = 0;
    public static Lock lock = new ReentrantLock();

    public static void incrementCounter() {
        if (lock.tryLock()) {
            try {
                int current = count;
                System.out.println("Before: " + current + " ThreadId: " + Thread.currentThread().getId());
                count = current + 1;
                System.out.println("After: " + count + " ThreadId: " + Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        } else System.out.println("Thread failed to increment " + Thread.currentThread().getId());
    }

    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(CountUsingLock::incrementCounter);
            t.start();
        }
    }
}
