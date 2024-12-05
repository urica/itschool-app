package com.itschool.jpa.otherstuff.designpatterns;

import java.util.ArrayList;
import java.util.List;

class Pizza {
    private String blat;
    private String sos;
    private List<String> toppings;

    public static class PizzaBuilder {
        private Pizza pizza;

        public PizzaBuilder() {
            pizza = new Pizza();
            pizza.toppings = new ArrayList<>();
        }

        public PizzaBuilder blat(String blat) {
            pizza.blat = blat;
            return this;
        }

        public PizzaBuilder sos(String sos) {
            pizza.sos = sos;
            return this;
        }

        public PizzaBuilder addTopping(String topping) {
            pizza.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }

    @Override
    public String toString() {
        return "Pizza cu blat " + blat + ", sos " + sos + " si topinguri: " + toppings;
    }
}

class PizzaB {
    private String blat;
    private String sos;
    private List<String> toppings;

    public PizzaB withBlat(String blat) {
        this.blat = blat;
        return this;
    }

    public PizzaB withSos(String sos) {
        this.sos = sos;
        return this;
    }

    public PizzaB withTopping(String topping) {
        if (toppings == null) {
            toppings = new ArrayList<>();
        }
        toppings.add(topping);
        return this;
    }

    @Override
    public String toString() {
        return "Pizza cu blat " + blat + ", sos " + sos + " si topinguri: " + toppings;
    }
}

public class Builder {
    public static void main(String... a) {
        Pizza pizza1 = new Pizza.PizzaBuilder()
                .blat("subtire")
                .sos("rosii")
                .addTopping("mozzarella")
                .addTopping("busuioc")
                .build();

        PizzaB pizza2 = new PizzaB()
                .withBlat("gros")
                .withSos("rosii")
                .withTopping("sunca")
                .withTopping("mozzarella");

        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}
