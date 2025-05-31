package com.examples.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizeArrayList {
    public static void main(String[] args) {
        // Step 1: Creating an ArrayList
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Step 2: Synchronizing the ArrayList
        List<String> syncList = Collections.synchronizedList(list);

        // Step 3: Accessing the synchronized ArrayList from multiple threads
        Thread thread1 = new Thread(() -> {
            synchronized (syncList) {
                syncList.forEach(System.out::println);
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (syncList) {
                syncList.add("JavaScript");
                System.out.println("Added JavaScript");
            }
        });

        thread1.start();
        thread2.start();
    }
}