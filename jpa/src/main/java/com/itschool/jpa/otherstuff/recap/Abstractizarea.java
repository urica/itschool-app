package com.itschool.jpa.otherstuff.recap;

public class Abstractizarea {
    public static void main(String... a) {
        PremiumUser premiumUser = new PremiumUser("S", 30, 7);
        StandartUser standartUser = new StandartUser("P", 26, 18);

        premiumUser.displayInfo();
        standartUser.displayInfo();

        premiumUser.calculateDiscount();
        standartUser.calculateDiscount();
    }
}

abstract class User {
    protected String name;
    protected int age;

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public abstract double calculateDiscount();

    public void displayInfo() {
        System.out.println("NAME: " + name + " age: " + age);
    }
}

class StandartUser extends User {
    private int numberOfPurchases;

    public StandartUser(String name, int age, int numberOfPurchases) {
        super(name, age);
        this.numberOfPurchases = numberOfPurchases;
    }


    @Override
    public double calculateDiscount() {
        return numberOfPurchases > 10 ? 0.1 : 0.0;
    }
}

class PremiumUser extends User {
    private int numberOfPurchases;

    public PremiumUser(String name, int age, int numberOfPurchases) {
        super(name, age);
        this.numberOfPurchases = numberOfPurchases;
    }


    @Override
    public double calculateDiscount() {
        return numberOfPurchases > 10 ? 0.2 : 0.0;
    }
}
