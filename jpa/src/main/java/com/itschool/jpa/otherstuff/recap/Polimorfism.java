package com.itschool.jpa.otherstuff.recap;

public class Polimorfism {
    public static void main(String... a) {
        Food pizza = new Pizza();
        Food salad = new Salad();

        System.out.println(pizza.getPrice());
        System.out.println(salad.getPrice());

        pizza.preparare();
        salad.preparare();
    }
}

interface Food {
    void preparare();

    double getPrice();
}

class Pizza implements Food {

    @Override
    public void preparare() {
        System.out.println("Prepara pizza!");
    }

    @Override
    public double getPrice() {
        return 12;
    }
}

class Salad implements Food {

    @Override
    public void preparare() {
        System.out.println("Prepara salata");
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
