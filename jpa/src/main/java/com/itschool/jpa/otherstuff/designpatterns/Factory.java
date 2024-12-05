package com.itschool.jpa.otherstuff.designpatterns;

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Ham ham!");
    }
}

class Cat implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Miau!");
    }
}

class Lion implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Roar!");
    }
}

class AnimalFactory {
    public Animal createAnimal(String type) {
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        } else if (type.equalsIgnoreCase("lion")) {
            return new Lion();
        }
        return null;
    }
}

public class Factory {
    public static void main(String... a) {
        AnimalFactory factory = new AnimalFactory();

        Animal dog = factory.createAnimal("dog");
        Animal cat = factory.createAnimal("Cat");
        Animal lion = factory.createAnimal("liOn");

        dog.makeSound();
        cat.makeSound();
        lion.makeSound();
    }
}
