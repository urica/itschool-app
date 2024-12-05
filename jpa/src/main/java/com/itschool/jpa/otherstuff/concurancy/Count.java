package com.itschool.jpa.otherstuff.concurancy;

public class Count {
    public static int count = 0;

    public static synchronized void incrementCounter() {
        int current = count;
        System.out.println("Before: " + current + " ThreadId: " + Thread.currentThread().getId());
        count = current + 1;
        System.out.println("After: " + count + " ThreadId: " + Thread.currentThread().getId());
    }

    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(Count::incrementCounter);
            t.start();
        }
    }
}
