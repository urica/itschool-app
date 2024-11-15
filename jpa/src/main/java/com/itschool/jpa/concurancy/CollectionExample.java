package com.itschool.jpa.concurancy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionExample {
    public static void main(String... args) {
        Map<String, String> stringStringMap = new ConcurrentHashMap<>();
        stringStringMap.put("Sam", "Java");
        stringStringMap.put("Daniel", "typeScript");

//        Set<String> keys = new HashSet<>(stringStringMap.keySet());

        for (String k : stringStringMap.keySet()) {
            System.out.println(k + " loves coding in: " + stringStringMap.get(k));
            stringStringMap.remove(k);
        }

        System.out.println("Size: " + stringStringMap.size());

    }
}
