package com.itschool.jpa.concurancy;

public class DeadlockExample {
    public static final Object RESOURCE1 = new Object();
    public static final Object RESOURCE2 = new Object();

    public static void main(String... args) {
        Thread t1 = new Thread(() -> {
            System.out.println("T1: incerc sa obtin resursa1");
            synchronized (RESOURCE1) {
                System.out.println("T1: am obtinut resursa1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("T1: incerc sa obtin resursa2");
                synchronized (RESOURCE2) {
                    System.out.println("T1: am obtinut resursa2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2: Incerc saobtin resursa1");
            synchronized (RESOURCE1) {
                System.out.println("T2: Am obtinut resursa1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("T2: incerc sa obtin resursa2");
                synchronized (RESOURCE2) {
                    System.out.println("T2: am obtinut resursa2");
                }
            }
        });

        t1.start();
        t2.start();
    }

}
