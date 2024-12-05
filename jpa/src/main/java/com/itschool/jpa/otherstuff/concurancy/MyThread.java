package com.itschool.jpa.otherstuff.concurancy;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Main {
    public static void main(String... args) {
        MyThread t = new MyThread();
//        t.setDaemon(true);
        t.start();
    }
}
