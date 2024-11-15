package com.itschool.jpa.concurancy;

public class CountObjectSync {
    public static int count = 0;
    public static Object lock = new Object();

    public static void incrementCounter() {
        synchronized (lock) {
            int current = count;
            System.out.println("Before: " + current + " ThreadId: " + Thread.currentThread().getId());
            count = current + 1;
            System.out.println("After: " + count + " ThreadId: " + Thread.currentThread().getId());
        }
    }

    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(CountObjectSync::incrementCounter);
            t.start();
        }
    }
}
